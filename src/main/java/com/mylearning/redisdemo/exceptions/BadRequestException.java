package com.mylearning.redisdemo.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(final String message) {
        super(message);
    }

}
