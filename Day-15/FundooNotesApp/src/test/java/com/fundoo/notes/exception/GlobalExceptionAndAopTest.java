package com.fundoo.notes.exception;

import com.fundoo.notes.dto.ErrorResponse;
import com.fundoo.notes.dto.NoteRequest;
import com.fundoo.notes.dto.NoteResponse;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.mapper.NoteMapper;
import com.fundoo.notes.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GlobalExceptionAndAopTest {

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private NoteService noteService;

    @Test
    void testResourceNotFoundExceptionHandling() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Note with ID 9999 not found");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/notes/9999");

        var response = globalExceptionHandler.handleResourceNotFoundException(ex, request);

        assertEquals(404, response.getStatusCode().value());
        ErrorResponse body = response.getBody();
        assertNotNull(body);
        assertEquals(404, body.getStatus());
        assertEquals("Note with ID 9999 not found", body.getMessage());
        assertEquals("/api/notes/9999", body.getPath());
    }

    @Test
    void testUnauthorizedAccessExceptionHandling() {
        UnauthorizedAccessException ex = new UnauthorizedAccessException("Not authorized to access note");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/notes/10");

        var response = globalExceptionHandler.handleUnauthorizedAccessException(ex, request);

        assertEquals(403, response.getStatusCode().value());
        ErrorResponse body = response.getBody();
        assertNotNull(body);
        assertEquals(403, body.getStatus());
        assertEquals("Not authorized to access note", body.getMessage());
    }

    @Test
    void testUserAlreadyExistsExceptionHandling() {
        UserAlreadyExistsException ex = new UserAlreadyExistsException("Email is already registered: test@example.com");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/auth/register");

        var response = globalExceptionHandler.handleUserAlreadyExistsException(ex, request);

        assertEquals(409, response.getStatusCode().value());
        ErrorResponse body = response.getBody();
        assertNotNull(body);
        assertEquals(409, body.getStatus());
        assertEquals("Email is already registered: test@example.com", body.getMessage());
    }

    @Test
    void testNoteMapperToEntityAndResponse() {
        User user = new User("John", "Doe", "john.doe@example.com", "secret123");
        user.setId(5L);

        NoteRequest request = new NoteRequest("Test Title", "Test Description");
        Note entity = noteMapper.toEntity(request, user);

        assertNotNull(entity);
        assertEquals("Test Title", entity.getTitle());
        assertEquals("Test Description", entity.getDescription());
        assertEquals(user, entity.getUser());

        NoteResponse response = noteMapper.toResponse(entity);
        assertNotNull(response);
        assertEquals("Test Title", response.getTitle());
        assertEquals("john.doe@example.com", response.getUserEmail());
    }
}
