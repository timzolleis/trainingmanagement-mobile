package com.tim.trainingmanagement.control;


import com.tim.trainingmanagement.entity.Clerk;

import java.util.Arrays;

public class LoginC {

    public final String login(final String username, final String password, final Boolean isAdmin) {
        try {
            final Clerk clerk = Clerk.login(username, password, isAdmin);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void printClerkNames() {
        System.out.println("Printing all clerk names");
        System.out.println(Arrays.toString(Clerk.getAllNames()));
    }

}
