package com.fundoo.notes.mapper;

import com.fundoo.notes.dto.NoteRequest;
import com.fundoo.notes.dto.NoteResponse;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.Tag;
import com.fundoo.notes.entity.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    public Note toEntity(NoteRequest request, User user) {
        if (request == null) {
            return null;
        }
        return new Note(request.getTitle(), request.getDescription(), user);
    }

    public NoteResponse toResponse(Note note) {
        if (note == null) {
            return null;
        }

        Set<String> tagNames = note.getTags().stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());

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
