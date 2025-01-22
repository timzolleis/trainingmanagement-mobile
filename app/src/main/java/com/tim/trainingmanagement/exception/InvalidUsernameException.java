package com.tim.trainingmanagement.exception;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException(final String message) {
        super(message);
    }
}
