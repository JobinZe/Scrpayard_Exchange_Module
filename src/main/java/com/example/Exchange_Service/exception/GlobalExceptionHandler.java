package com.example.Exchange_Service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // ✅ Catch generic exceptions (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        logger.error("Unexpected error occurred", ex);

        Map<String, Object> error = new HashMap<>();
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("error", "Internal Server Error");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ✅ Catch JSON parse errors (invalid/malformed JSON in request)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleJsonParseError(HttpMessageNotReadableException ex) {
        logger.error("Malformed JSON request", ex);

        Map<String, Object> error = new HashMap<>();
        error.put("status", HttpStatus.BAD_REQUEST.value());
        error.put("error", "Malformed JSON request");
        error.put("message", ex.getMostSpecificCause().getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // ✅ Catch invalid request parameter types (?id=abc when expecting int)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        logger.error("Request parameter type mismatch", ex);

        Map<String, Object> error = new HashMap<>();
        error.put("status", HttpStatus.BAD_REQUEST.value());
        error.put("error", "Invalid parameter type");
        error.put("message", String.format("Parameter '%s' should be of type %s",
                ex.getName(), ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "unknown"));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // ✅ Catch missing required parameters (?id= missing)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleMissingParams(MissingServletRequestParameterException ex) {
        logger.error("Missing request parameter", ex);

        Map<String, Object> error = new HashMap<>();
        error.put("status", HttpStatus.BAD_REQUEST.value());
        error.put("error", "Missing parameter");
        error.put("message", String.format("Parameter '%s' is required", ex.getParameterName()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // ✅ Catch @Valid validation errors (DTO validation failures)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        logger.error("Validation error", ex);

        Map<String, Object> error = new HashMap<>();
        error.put("status", HttpStatus.BAD_REQUEST.value());
        error.put("error", "Validation failed");
        error.put("message", ex.getBindingResult().getFieldError() != null
                ? ex.getBindingResult().getFieldError().getDefaultMessage()
                : "Invalid request");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
