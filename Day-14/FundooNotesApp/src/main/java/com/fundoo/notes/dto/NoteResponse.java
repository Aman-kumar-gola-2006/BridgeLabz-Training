package com.fundoo.notes.dto;

import com.fundoo.notes.entity.Note.NoteState;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class NoteResponse {

    private Long id;
    private String title;
    private String description;
    private NoteState state;
    private boolean pinned;
    private Set<String> tags = new HashSet<>();
    private LocalDateTime reminderAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;
    private String userEmail;
    private String attachmentFileName;

    public NoteResponse() {
    }

    public NoteResponse(Long id, String title, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId, String userEmail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = NoteState.ACTIVE;
        this.pinned = false;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.userEmail = userEmail;
    }

    public NoteResponse(Long id, String title, String description, NoteState state, boolean pinned, Set<String> tags, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId, String userEmail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.pinned = pinned;
        this.tags = tags;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.userEmail = userEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NoteState getState() {
        return state;
    }

    public void setState(NoteState state) {
        this.state = state;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public LocalDateTime getReminderAt() {
        return reminderAt;
    }

    public void setReminderAt(LocalDateTime reminderAt) {
        this.reminderAt = reminderAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAttachmentFileName() {
        return attachmentFileName;
    }

    public void setAttachmentFileName(String attachmentFileName) {
        this.attachmentFileName = attachmentFileName;
    }
}

