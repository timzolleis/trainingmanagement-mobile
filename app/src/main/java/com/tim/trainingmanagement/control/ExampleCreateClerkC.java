package com.tim.trainingmanagement.control;


import com.tim.trainingmanagement.entity.Clerk;

public class ExampleCreateClerkC {

    public final String addClerk(final String username, final String password, final boolean isAdmin) {
        try {
            Clerk.addClerk(new Clerk(username, password, isAdmin));
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return null;
    }

}
