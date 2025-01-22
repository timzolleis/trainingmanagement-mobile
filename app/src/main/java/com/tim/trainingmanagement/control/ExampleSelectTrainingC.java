package com.tim.trainingmanagement.control;


import com.tim.trainingmanagement.entity.Clerk;
import com.tim.trainingmanagement.entity.Training;

import java.util.Collection;
import java.util.Set;

public class ExampleSelectTrainingC {
    public String[] getAllNames() {
        return Training.getAllNames();
    }


    public final String[] getTrainingNamesToAttend(final String username) {
        final Clerk clerk = Clerk.getClerk(username);
        final Collection<Training> trainings = Training.getAllTrainings().values();
        return trainings.stream().filter(training -> isToAttend(clerk, training)).map(Training::getName).toArray(String[]::new);

    }

    public final String[] getTrainingsNamesToComplete(final String username) {
        final Clerk clerk = Clerk.getClerk(username);
        final Collection<Training> trainings = Training.getAllTrainings().values();
        return trainings.stream().filter(training -> hasCompletedTraining(clerk, training)).map(Training::getName).toArray(String[]::new);
    }

    private boolean isToAttend(final Clerk clerk, final Training training) {
        return !clerk.hasAttendedTraining(training) && !clerk.hasCompletedTraining(training) && hasAllRequirements(clerk, training);
    }

    private boolean hasAllRequirements(final Clerk clerk, final Training training) {
        final Set<Training> requirements = training.getRequirements();
        return requirements.stream().allMatch(clerk::hasCompletedTraining);

    }

    private boolean hasCompletedTraining(final Clerk clerk, final Training training) {
        return !clerk.hasAttendedTraining(training) && hasAllRequirements(clerk, training);
    }

}
