package com.mylearning.redisdemo.exceptions;


import com.mylearning.redisdemo.domainmodel.error.ErrorResponse;
import com.mylearning.redisdemo.utils.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(BadRequestException exception) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatusCode(String.valueOf(HttpStatus.BAD_REQUEST))
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .errorStackTrace(ExceptionUtils.extractStacktrace(exception.getStackTrace()))
                .build();


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
