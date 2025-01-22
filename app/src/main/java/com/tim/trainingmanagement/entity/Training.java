package com.tim.trainingmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@Getter
public class Training {

    private final Set<Training> requirements;
    @Setter
    @Getter
    private static Map<String, Training> allTrainings = new HashMap<>();
    private final String name;

    public Training(Set<Training> requirements, String name) {
        this.requirements = requirements;
        this.name = name;
    }


    public static void addTraining(final Training training) {
        allTrainings.put(training.getName(), training);
    }

    public static String[] getAllNames() {
        return allTrainings.keySet().toArray(String[]::new);
    }

    public void add(final Training training) {
        allTrainings.put(training.getName(), training);
    }

    public void delete(final String trainingName) {
        if (!allTrainings.containsKey(trainingName)) {
            throw new NoSuchElementException("Training not found");
        }
        allTrainings.remove(trainingName);
    }

    public static Training getTraining(final String trainingName) {
        if (!allTrainings.containsKey(trainingName)) {
            throw new NoSuchElementException("Training not found");
        }
        return allTrainings.get(trainingName);
    }

    public boolean isRequiredBy(final Training training) {
        return training.getRequirements().contains(this);
    }

}
