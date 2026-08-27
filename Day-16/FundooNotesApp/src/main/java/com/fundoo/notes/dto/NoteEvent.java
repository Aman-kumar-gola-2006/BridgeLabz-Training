package com.fundoo.notes.dto;

import java.io.Serializable;

public class NoteEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long noteId;
    private String actionType; // CREATE, UPDATE, DELETE, ARCHIVE, etc.
    private String title;
    private String userEmail;
    private String timestamp;

    public NoteEvent() {
    }

    public NoteEvent(Long noteId, String actionType, String title, String userEmail, String timestamp) {
        this.noteId = noteId;
        this.actionType = actionType;
        this.title = title;
        this.userEmail = userEmail;
        this.timestamp = timestamp;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
