package com.thafonso.user_api.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Object id) {
        super("Resource not found. ID: " + id);
    }
}
