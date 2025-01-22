package com.tim.trainingmanagement.control;


import com.tim.trainingmanagement.entity.Clerk;
import com.tim.trainingmanagement.entity.Training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExampleDeleteTrainingMappingC {


    private String checkCanDeleteTrainingMapping(final Clerk Clerk, final Training trainingToDelete) {
        final Collection<Training> completedTrainings = Clerk.getCompletedTrainings().values();
        final Training requiredBy = completedTrainings.stream()
                .filter(trainingToDelete::isRequiredBy)
                .findFirst()
                .orElse(null);
        if (requiredBy != null) {
            return "The training " + trainingToDelete.getName() + " is required by the completed training " + requiredBy.getName() + ". \nIt cannot be deleted for the clerk " + Clerk.getUsername();
        }
        return null;
    }

    public final String deleteTrainingMapping(final String clerkName, final String trainingName) {
        final Clerk clerk = Clerk.getClerk(clerkName);
        final Training training = Training.getTraining(trainingName);
        if (clerk.hasAttendedTraining(training)) {
            clerk.removeAttendedTraining(training);
            return null;
        }
        final String error = this.checkCanDeleteTrainingMapping(clerk, training);
        if (error == null) {
            clerk.removeCompletedTraining(training);
            return null;
        }
        return error;
    }

    public final String[] getAttendedTrainings(final String selectedUsername) {
        return new ExampleShowTrainingMappingC().getAttendedTrainingNames(selectedUsername);
    }

    public final String[] getCompletedTrainings(final String selectedUsername) {
        return new ExampleShowTrainingMappingC().getCompletedTrainingNames(selectedUsername);
    }

    public final String[] getDeletableTrainings(final String selectedUsername) {
        final Collection<Training> attendedTrainings = Clerk.getClerk(selectedUsername).getAttendedTrainings().values();
        final Collection<Training> completedTrainings = Clerk.getClerk(selectedUsername).getCompletedTrainings().values();
        final List<Training> deletableCompletedTrainings = completedTrainings.stream().filter(training -> this.checkCanDeleteTrainingMapping(Clerk.getClerk(selectedUsername), training) == null).toList();

        final List<Training> deletableTrainings = new ArrayList<>(attendedTrainings);
        deletableTrainings.addAll(deletableCompletedTrainings);
        return deletableTrainings.stream().map(Training::getName).toArray(String[]::new);

    }

}
