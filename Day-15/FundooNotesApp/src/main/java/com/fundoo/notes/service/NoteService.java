package com.fundoo.notes.service;

import com.fundoo.notes.dto.NoteRequest;
import com.fundoo.notes.dto.NoteResponse;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.Note.NoteState;
import com.fundoo.notes.entity.Tag;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.repository.TagRepository;
import com.fundoo.notes.repository.UserRepository;
import com.fundoo.notes.specification.NoteSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.notes.messaging.RabbitMQProducer;
import com.fundoo.notes.messaging.ReminderProducer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fundoo.notes.mapper.NoteMapper;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final ReminderProducer reminderProducer;
    private final RabbitMQProducer rabbitMQProducer;
    private final NoteMapper noteMapper;

    public NoteService(NoteRepository noteRepository,
                       UserRepository userRepository,
                       TagRepository tagRepository,
                       ReminderProducer reminderProducer,
                       @org.springframework.beans.factory.annotation.Autowired(required = false) RabbitMQProducer rabbitMQProducer,
                       NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.reminderProducer = reminderProducer;
        this.rabbitMQProducer = rabbitMQProducer;
        this.noteMapper = noteMapper;
    }

    @Transactional
    public NoteResponse createNote(NoteRequest request, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));

        Note note = new Note(request.getTitle(), request.getDescription(), user);
        Note savedNote = noteRepository.save(note);

        if (rabbitMQProducer != null) {
            rabbitMQProducer.sendNoteEvent(savedNote.getId(), "NOTE_CREATED", savedNote.getTitle(), userEmail);
        }

        return mapToNoteResponse(savedNote);
    }

    @Transactional(readOnly = true)
    public List<NoteResponse> getUserNotes(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));

        List<Note> notes = noteRepository.findByUserOrderByCreatedAtDesc(user);
        return notes.stream()
                .map(this::mapToNoteResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NoteResponse getNoteById(Long noteId, String userEmail) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        return mapToNoteResponse(note);
    }

    @Transactional
    public NoteResponse updateNote(Long noteId, NoteRequest request, String userEmail) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        Note updatedNote = noteRepository.save(note);

        return mapToNoteResponse(updatedNote);
    }

    @Transactional
    public void deleteNote(Long noteId, String userEmail) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        noteRepository.delete(note);
    }

    @Transactional
    public NoteResponse archiveNote(Long noteId, String userEmail) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        note.setState(NoteState.ARCHIVED);
        note.setPinned(false);
        return mapToNoteResponse(noteRepository.save(note));
    }

    @Transactional
    public NoteResponse trashNote(Long noteId, String userEmail) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        note.setState(NoteState.TRASHED);
        note.setPinned(false);
        return mapToNoteResponse(noteRepository.save(note));
    }

    @Transactional
    public NoteResponse restoreNote(Long noteId, String userEmail) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        note.setState(NoteState.ACTIVE);
        return mapToNoteResponse(noteRepository.save(note));
    }

    @Transactional
    public NoteResponse pinNote(Long noteId, String userEmail) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        if (note.getState() == NoteState.TRASHED) {
            throw new IllegalStateException("Cannot pin a note that is in Trash");
        }
        note.setPinned(true);
        return mapToNoteResponse(noteRepository.save(note));
    }

    @Transactional(readOnly = true)
    public List<NoteResponse> search(String userEmail, String titleText, NoteState state, String tagName) {
        User owner = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));

        Specification<Note> spec = NoteSpecifications.search(owner, titleText, state, tagName);
        List<Note> notes = noteRepository.findAll(spec);

        return notes.stream()
                .map(this::mapToNoteResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public NoteResponse addTagToNote(Long noteId, String userEmail, String tagName) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);

        String trimmedTag = tagName != null ? tagName.trim() : "";
        if (trimmedTag.isEmpty()) {
            throw new IllegalArgumentException("Tag name cannot be empty");
        }

        Tag tag = tagRepository.findByName(trimmedTag)
                .orElseGet(() -> tagRepository.save(new Tag(trimmedTag)));

        note.getTags().add(tag);
        return mapToNoteResponse(noteRepository.save(note));
    }

    @Transactional
    public NoteResponse removeTagFromNote(Long noteId, String userEmail, String tagName) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        Tag tag = tagRepository.findByName(tagName).orElse(null);
        if (tag != null) {
            note.getTags().remove(tag);
            noteRepository.save(note);
        }
        return mapToNoteResponse(note);
    }

    @Transactional
    public NoteResponse setReminder(Long noteId, String userEmail, LocalDateTime reminderTime) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        note.setReminderAt(reminderTime);
        Note savedNote = noteRepository.save(note);

        if (reminderProducer != null) {
            reminderProducer.sendReminderNotification(userEmail, savedNote.getId(), savedNote.getTitle(), reminderTime.toString());
        }

        return mapToNoteResponse(savedNote);
    }

    @Transactional
    public NoteResponse uploadAttachment(Long noteId, String userEmail, MultipartFile file) throws IOException {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Cannot upload empty file");
        }

        String originalFilename = file.getOriginalFilename();
        Path uploadDir = Paths.get("uploads");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        String storedFileName = System.currentTimeMillis() + "_" + (originalFilename != null ? originalFilename : "file");
        Path targetPath = uploadDir.resolve(storedFileName);
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        note.setAttachmentFileName(originalFilename);
        note.setAttachmentPath(targetPath.toString());
        Note savedNote = noteRepository.save(note);

        if (rabbitMQProducer != null) {
            rabbitMQProducer.sendNoteEvent(savedNote.getId(), "ATTACHMENT_UPLOADED", savedNote.getTitle(), userEmail);
        }

        return mapToNoteResponse(savedNote);
    }

    @Transactional(readOnly = true)
    public Path getAttachmentFile(Long noteId, String userEmail) {
        Note note = getOwnedNoteOrThrow(noteId, userEmail);
        if (note.getAttachmentPath() == null) {
            throw new RuntimeException("Note has no file attachment!");
        }
        Path path = Paths.get(note.getAttachmentPath());
        if (!Files.exists(path)) {
            throw new RuntimeException("Attachment file not found on server storage!");
        }
        return path;
    }

    public Note getOwnedNoteOrThrow(Long noteId, String userEmail) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new com.fundoo.notes.exception.ResourceNotFoundException("Note not found with ID: " + noteId));

        if (!note.getUser().getEmail().equals(userEmail)) {
            throw new com.fundoo.notes.exception.UnauthorizedAccessException("You are not authorized to access this note!");
        }

        return note;
    }

    private NoteResponse mapToNoteResponse(Note note) {
        if (noteMapper != null) {
            return noteMapper.toResponse(note);
        }
        Set<String> tagNames = note.getTags() != null ? note.getTags().stream()
                .map(Tag::getName)
                .collect(Collectors.toSet()) : java.util.Collections.emptySet();

        NoteResponse response = new NoteResponse(
                note.getId(),
                note.getTitle(),
                note.getDescription(),
                note.getState(),
                note.isPinned(),
                tagNames,
                note.getCreatedAt(),
                note.getUpdatedAt(),
                note.getUser() != null ? note.getUser().getId() : null,
                note.getUser() != null ? note.getUser().getEmail() : null
        );
        response.setReminderAt(note.getReminderAt());
        response.setAttachmentFileName(note.getAttachmentFileName());
        return response;
    }
}
