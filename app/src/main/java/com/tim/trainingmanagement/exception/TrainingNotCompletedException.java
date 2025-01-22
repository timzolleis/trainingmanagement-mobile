package com.tim.trainingmanagement.exception;

public class TrainingNotCompletedException extends RuntimeException {
    public TrainingNotCompletedException(String training) {
        super("Training " + training + " not completed");
    }
}
