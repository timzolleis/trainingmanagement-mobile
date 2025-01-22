package com.tim.trainingmanagement.exception;

public class TrainingNotAttendedException extends RuntimeException {
    public TrainingNotAttendedException(String training) {
        super("Training " + training + " not attended");
    }
}
