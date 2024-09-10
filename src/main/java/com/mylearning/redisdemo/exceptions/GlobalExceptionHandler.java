package com.mylearning.redisdemo.exceptions;

import com.mylearning.redisdemo.domainmodel.error.ErrorResponse;
import com.mylearning.redisdemo.utils.exception.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception genericException) {
        logErrorWithExceptionDetails(genericException, HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorResponse genericExceptionErrorResponse = createErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, genericException.getMessage(), genericException);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(genericExceptionErrorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        logErrorWithExceptionDetails(dataIntegrityViolationException, HttpStatus.BAD_REQUEST);

        ErrorResponse dataIntegrityViolationExceptionErrorResponse = createErrorResponse(
                HttpStatus.BAD_REQUEST, dataIntegrityViolationException.getMessage(), dataIntegrityViolationException
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dataIntegrityViolationExceptionErrorResponse);

    }


    private void logErrorWithExceptionDetails(Exception exception, HttpStatus httpStatus) {
        log.error("Exception: " + httpStatus, exception);
    }

    private ErrorResponse createErrorResponse(HttpStatus status, String message, Exception exception) {
        return ErrorResponse.builder()
                .httpStatusCode(String.valueOf(status))
                .message(message)
                .timestamp(LocalDateTime.now())
                .errorStackTrace(ExceptionUtils.extractStacktrace(exception.getStackTrace()))
                .build();
    }
}
