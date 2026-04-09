package com.thafonso.user_api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandartError> notFoundException(NotFoundException notFoundException, HttpServletRequest request) {
        String error = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND; // error 404
        StandartError standartError = new StandartError(Instant.now(), status.value(), error, notFoundException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standartError);
    }

}
