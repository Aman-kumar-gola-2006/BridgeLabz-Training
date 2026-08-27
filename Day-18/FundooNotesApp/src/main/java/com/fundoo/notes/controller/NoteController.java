package com.fundoo.notes.controller;

import com.fundoo.notes.dto.NoteRequest;
import com.fundoo.notes.dto.NoteResponse;
import com.fundoo.notes.entity.Note.NoteState;
import com.fundoo.notes.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(
            @Valid @RequestBody NoteRequest request,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        NoteResponse response = noteService.createNote(request, userEmail);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getUserNotes(Authentication authentication) {
        String userEmail = authentication.getName();
        List<NoteResponse> notes = noteService.getUserNotes(userEmail);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> getNoteById(
            @PathVariable Long id,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        NoteResponse response = noteService.getNoteById(id, userEmail);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponse> updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequest request,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        NoteResponse response = noteService.updateNote(id, request, userEmail);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteNote(
            @PathVariable Long id,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        noteService.deleteNote(id, userEmail);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Note deleted successfully with ID: " + id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/archive")
    public ResponseEntity<NoteResponse> archiveNote(
            @PathVariable Long id,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(noteService.archiveNote(id, userEmail));
    }

    @PatchMapping("/{id}/trash")
    public ResponseEntity<NoteResponse> trashNote(
            @PathVariable Long id,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(noteService.trashNote(id, userEmail));
    }

    @PatchMapping("/{id}/restore")
    public ResponseEntity<NoteResponse> restoreNote(
            @PathVariable Long id,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(noteService.restoreNote(id, userEmail));
    }

    @PatchMapping("/{id}/pin")
    public ResponseEntity<NoteResponse> pinNote(
            @PathVariable Long id,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(noteService.pinNote(id, userEmail));
    }

    @GetMapping("/search")
    public ResponseEntity<List<NoteResponse>> searchNotes(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) NoteState state,
            @RequestParam(required = false) String tag,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(noteService.search(userEmail, title, state, tag));
    }

    @PostMapping("/{id}/tags")
    public ResponseEntity<NoteResponse> addTagToNote(
            @PathVariable Long id,
            @RequestBody String tagName,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        // Clean json body if passed raw string or simple text
        String cleanTagName = tagName != null ? tagName.replace("\"", "").trim() : "";
        return ResponseEntity.ok(noteService.addTagToNote(id, userEmail, cleanTagName));
    }

    @DeleteMapping("/{id}/tags/{tagName}")
    public ResponseEntity<NoteResponse> removeTagFromNote(
            @PathVariable Long id,
            @PathVariable String tagName,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(noteService.removeTagFromNote(id, userEmail, tagName));
    }

    @PostMapping("/{id}/reminder")
    public ResponseEntity<NoteResponse> setReminder(
            @PathVariable Long id,
            @RequestBody(required = false) Map<String, String> body,
            Authentication authentication
    ) {
        String userEmail = authentication.getName();
        String timeStr = body != null ? body.get("reminderAt") : null;
        java.time.LocalDateTime reminderTime = timeStr != null ? java.time.LocalDateTime.parse(timeStr) : java.time.LocalDateTime.now().plusDays(1);
        return ResponseEntity.ok(noteService.setReminder(id, userEmail, reminderTime));
    }

    @PostMapping(value = "/{id}/attachment", consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<NoteResponse> uploadAttachment(
            @PathVariable Long id,
            @RequestParam("file") org.springframework.web.multipart.MultipartFile file,
            Authentication authentication
    ) throws java.io.IOException {
        String userEmail = authentication.getName();
        NoteResponse response = noteService.uploadAttachment(id, userEmail, file);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/attachment")
    public ResponseEntity<org.springframework.core.io.Resource> downloadAttachment(
            @PathVariable Long id,
            Authentication authentication
    ) throws java.net.MalformedURLException {
        String userEmail = authentication.getName();
        java.nio.file.Path filePath = noteService.getAttachmentFile(id, userEmail);
        org.springframework.core.io.Resource resource = new org.springframework.core.io.UrlResource(filePath.toUri());

        return ResponseEntity.ok()
                .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filePath.getFileName().toString() + "\"")
                .body(resource);
    }
}
