package com.charles.sevenbankapi.adapter.in.rest;

import com.charles.sevenbankapi.common.dto.ErrorDTO;
import com.charles.sevenbankapi.common.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO("NOT_FOUND", ex.getMessage()));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDTO> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO("INTERNAL_SERVER_ERROR", ex.getMessage()));
    }
}
