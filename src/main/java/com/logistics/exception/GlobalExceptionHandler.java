package com.logistics.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.BindException;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(BindException ex) {
        return ResponseEntity.badRequest()
                .body(Map.of("error", "Invalid request parameters",
                        "details", ex.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }
}