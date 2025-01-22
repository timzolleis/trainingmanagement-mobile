package com.tim.trainingmanagement.control;

public class ExampleShowTrainingMappingC {

    public final String[] getCompletedTrainingNames(final String username) {
        return new ExampleSelectTrainingMappingC().getCompletedTrainingNames(username);
    }

    public final String[] getAttendedTrainingNames(final String username) {
        return new ExampleSelectTrainingMappingC().getAttendedTrainingNames(username);
    }

}
