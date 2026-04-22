package com.thafonso.user_api.exceptions;

import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError {

    private LocalDateTime timestamp;
    private int status;
    private List<FielMessage> errors = new ArrayList<>();

    public ValidationError(int status) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public void addError(String field, String message) {
        errors.add(new FielMessage(field, message));
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

    public List<FielMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<FielMessage> errors) {
        this.errors = errors;
    }
}
