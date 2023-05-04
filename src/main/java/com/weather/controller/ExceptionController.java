package com.weather.controller;

import com.weather.core.ErrorResponse;
import com.weather.core.ValidationResponse;
import com.weather.enumeration.ResponseStatus;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
@RestControllerAdvice
public class ExceptionController {

    @ApiResponse(responseCode = "400", description = "Bad request")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, ServletWebRequest request) {
        log.error("400 Bad Request error {}", ex.getMessage());
        List<ValidationResponse> validationResponses = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fileName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            ValidationResponse validationResponse = new ValidationResponse(fileName, errorMessage);
            validationResponses.add(validationResponse);
        });
        return ResponseEntity.status(ResponseStatus.VALIDATION_ERROR.getHttpStatus())
                .body(ErrorResponse
                        .builder().status(ResponseStatus.VALIDATION_ERROR)
                        .path(request.getRequest().getRequestURI())
                        .validation(validationResponses).build());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    public ResponseEntity<Void> unauthorized(AuthenticationException ex) {
        log.error("401 Unauthorized error {}", ex.getMessage());
        return ResponseEntity.status(ResponseStatus.UNAUTHORIZED.getHttpStatus()).build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ApiResponse(responseCode = "403", description = "Forbidden")
    public ResponseEntity<Void> forbidden(AccessDeniedException ex) {
        log.error("403 Forbidden error {}", ex.getMessage());
        return ResponseEntity.status(ResponseStatus.FORBIDDEN.getHttpStatus()).build();
    }

    @ExceptionHandler(Exception.class)
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Void> exception(Exception ex) {
        log.error("500 Internal error {}", ex.getMessage());
        return ResponseEntity.status(ResponseStatus.INTERNAL_SERVER_ERROR.getHttpStatus()).build();
    }
}
