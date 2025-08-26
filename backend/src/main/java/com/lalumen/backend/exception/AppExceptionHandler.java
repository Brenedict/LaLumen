package com.lalumen.backend.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> accountNotFoundHandler(AccountNotFoundException exception, HttpServletRequest request) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                                                    ZonedDateTime.now(), 
                                                    HttpStatus.NOT_FOUND.value(), 
                                                    request.getRequestURI(), 
                                                    exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> genericHandler(RuntimeException exception, HttpServletRequest request) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                                                    ZonedDateTime.now(), 
                                                    HttpStatus.NOT_FOUND.value(), 
                                                    request.getRequestURI(), 
                                                    exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
