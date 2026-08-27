package com.cjc.payroll.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Standardized Error Response Structure")
public class ErrorResponse {

    @Schema(description = "Timestamp when error occurred", example = "2026-08-17T11:45:00")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP Status code", example = "400")
    private int status;

    @Schema(description = "Error summary message", example = "Validation Failed")
    private String message;

    @Schema(description = "Detailed error messages or field errors")
    private Object details;

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDateTime timestamp, int status, String message, Object details) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }
}
