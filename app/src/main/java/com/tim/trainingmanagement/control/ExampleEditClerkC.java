package com.tim.trainingmanagement.control;


import com.tim.trainingmanagement.entity.Clerk;

public class ExampleEditClerkC {

    public final Boolean isCurrentlyAdmin(final String username) {
        return Clerk.getClerk(username).isAdmin();
    }

    public final String getCurrentPassword(final String username) {
        return Clerk.getClerk(username).getPassword();
    }

    public final String updateClerk(final String oldUsername, final String newUsername, final String password, final Boolean isAdmin) {
        final Clerk clerk = Clerk.getClerk(oldUsername);
        try {
            clerk.setUsername(newUsername);
            clerk.setPassword(password);
            clerk.setRole(isAdmin == null ? clerk.isAdmin() : isAdmin);
            return null;
        } catch (final Exception e) {
            return e.getMessage();
        }
    }
}
