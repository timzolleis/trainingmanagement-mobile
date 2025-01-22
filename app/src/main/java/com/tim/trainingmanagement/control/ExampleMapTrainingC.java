package com.tim.trainingmanagement.control;


import com.tim.trainingmanagement.entity.Clerk;
import com.tim.trainingmanagement.entity.Training;

//TODO: Its not checked if the training is required by something
public class ExampleMapTrainingC {

    public final String attendTraining(final String clerkName, final String trainingName) {
        final Training training = Training.getTraining(trainingName);
        final Clerk clerk = Clerk.getClerk(clerkName);
        final Training requiredTraining = training.getRequirements().stream()
                .filter(requirement -> !clerk.getCompletedTrainings().containsKey(requirement.getName()))
                .findFirst()
                .orElse(null);
        if (requiredTraining != null) {
            return "The training " + trainingName + " requires the training " + requiredTraining.getName() + " to be completed first.";
        }
        clerk.addAttendedTraining(training);
        return null;
    }

    public String completeTraining(final String clerkName, final String trainingName) {
        final Training training = Training.getTraining(trainingName);
        final Clerk clerk = Clerk.getClerk(clerkName);
        final boolean hasAttendedTraining = clerk.getAttendedTrainings().containsKey(trainingName);
        if (!hasAttendedTraining) {
            return "The clerk " + clerkName + " has not attended the training " + trainingName + ".";
        }
        clerk.addCompletedTraining(training);
        return null;
    }


}
