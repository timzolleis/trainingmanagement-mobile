package com.tim.trainingmanagement.control;


import com.tim.trainingmanagement.entity.Clerk;

public class ExampleClerkC {

    final String getPassword(final String username) {
        return Clerk.getClerk(username).getPassword();
    }

    final boolean getPermission(final String username) {
        return Clerk.getClerk(username).isAdmin();
    }


}
