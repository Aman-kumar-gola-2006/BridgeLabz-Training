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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.fundoo.notes.messaging.ReminderProducer;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TagRepository tagRepository;

    @Mock
    private ReminderProducer reminderProducer;

    @org.mockito.Spy
    private com.fundoo.notes.mapper.NoteMapper noteMapper = new com.fundoo.notes.mapper.NoteMapper();

    @InjectMocks
    private NoteService noteService;

    private User user1;
    private User user2;
    private Note note1;

    @BeforeEach
    void setUp() {
        user1 = new User("Aman", "Gola", "user1@example.com", "password123");
        user1.setId(1L);

        user2 = new User("Rahul", "Sharma", "user2@example.com", "password456");
        user2.setId(2L);

        note1 = new Note("Day 14 Concepts", "Authorization & JPA Entity Relationships", user1);
        note1.setId(101L);
    }

    @Test
    void testCreateNote_Success() {
        NoteRequest request = new NoteRequest("Day 14 Concepts", "Authorization & JPA Entity Relationships");

        when(userRepository.findByEmail("user1@example.com")).thenReturn(Optional.of(user1));
        when(noteRepository.save(any(Note.class))).thenReturn(note1);

        NoteResponse response = noteService.createNote(request, "user1@example.com");

        assertNotNull(response);
        assertEquals("Day 14 Concepts", response.getTitle());
        assertEquals("user1@example.com", response.getUserEmail());
        verify(noteRepository, times(1)).save(any(Note.class));
    }

    @Test
    void testGetUserNotes_Success() {
        when(userRepository.findByEmail("user1@example.com")).thenReturn(Optional.of(user1));
        when(noteRepository.findByUserOrderByCreatedAtDesc(user1)).thenReturn(List.of(note1));

        List<NoteResponse> responses = noteService.getUserNotes("user1@example.com");

        assertEquals(1, responses.size());
        assertEquals("Day 14 Concepts", responses.get(0).getTitle());
    }

    @Test
    void testDeleteNote_Success() {
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));

        assertDoesNotThrow(() -> noteService.deleteNote(101L, "user1@example.com"));
        verify(noteRepository, times(1)).delete(note1);
    }

    @Test
    void testDeleteNote_UnauthorizedAccess_ThrowsException() {
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> noteService.deleteNote(101L, "user2@example.com")
        );

        assertEquals("You are not authorized to access this note!", exception.getMessage());
        verify(noteRepository, never()).delete(any(Note.class));
    }

    @Test
    void testDeleteNote_NotFound_ThrowsException() {
        when(noteRepository.findById(999L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> noteService.deleteNote(999L, "user1@example.com")
        );

        assertEquals("Note not found with ID: 999", exception.getMessage());
    }

    @Test
    void testArchiveNote_Success() {
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));
        when(noteRepository.save(any(Note.class))).thenAnswer(i -> i.getArgument(0));

        NoteResponse response = noteService.archiveNote(101L, "user1@example.com");

        assertNotNull(response);
        assertEquals(NoteState.ARCHIVED, response.getState());
        assertFalse(response.isPinned());
    }

    @Test
    void testTrashNote_Success() {
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));
        when(noteRepository.save(any(Note.class))).thenAnswer(i -> i.getArgument(0));

        NoteResponse response = noteService.trashNote(101L, "user1@example.com");

        assertNotNull(response);
        assertEquals(NoteState.TRASHED, response.getState());
        assertFalse(response.isPinned());
    }

    @Test
    void testRestoreNote_Success() {
        note1.setState(NoteState.TRASHED);
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));
        when(noteRepository.save(any(Note.class))).thenAnswer(i -> i.getArgument(0));

        NoteResponse response = noteService.restoreNote(101L, "user1@example.com");

        assertNotNull(response);
        assertEquals(NoteState.ACTIVE, response.getState());
    }

    @Test
    void testPinNote_Success() {
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));
        when(noteRepository.save(any(Note.class))).thenAnswer(i -> i.getArgument(0));

        NoteResponse response = noteService.pinNote(101L, "user1@example.com");

        assertNotNull(response);
        assertTrue(response.isPinned());
    }

    @Test
    void testPinNote_WhenTrashed_ThrowsIllegalStateException() {
        note1.setState(NoteState.TRASHED);
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> noteService.pinNote(101L, "user1@example.com")
        );

        assertEquals("Cannot pin a note that is in Trash", exception.getMessage());
    }

    @Test
    void testAddTagToNote_Success() {
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));
        when(tagRepository.findByName("Work")).thenReturn(Optional.of(new Tag(1L, "Work")));
        when(noteRepository.save(any(Note.class))).thenAnswer(i -> i.getArgument(0));

        NoteResponse response = noteService.addTagToNote(101L, "user1@example.com", "Work");

        assertNotNull(response);
        assertTrue(response.getTags().contains("Work"));
    }

    @Test
    void testSearchNotes_Success() {
        when(userRepository.findByEmail("user1@example.com")).thenReturn(Optional.of(user1));
        when(noteRepository.findAll(any(Specification.class))).thenReturn(List.of(note1));

        List<NoteResponse> responses = noteService.search("user1@example.com", "Concepts", NoteState.ACTIVE, "Work");

        assertEquals(1, responses.size());
        assertEquals("Day 14 Concepts", responses.get(0).getTitle());
    }

    @Test
    void testSetReminder_Success() {
        when(noteRepository.findById(101L)).thenReturn(Optional.of(note1));
        when(noteRepository.save(any(Note.class))).thenAnswer(i -> i.getArgument(0));

        LocalDateTime reminderTime = LocalDateTime.now().plusDays(1);
        NoteResponse response = noteService.setReminder(101L, "user1@example.com", reminderTime);

        assertNotNull(response);
        assertEquals(reminderTime, response.getReminderAt());
        verify(reminderProducer, times(1)).sendReminderNotification(eq("user1@example.com"), eq(101L), anyString(), anyString());
    }
}
