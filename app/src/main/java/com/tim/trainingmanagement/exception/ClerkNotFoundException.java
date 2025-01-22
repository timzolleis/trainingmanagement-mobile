package com.tim.trainingmanagement.exception;

import java.util.NoSuchElementException;

public class ClerkNotFoundException extends NoSuchElementException {
    public ClerkNotFoundException(String username) {
        super("Clerk with username " + username + " not found");
    }
}
