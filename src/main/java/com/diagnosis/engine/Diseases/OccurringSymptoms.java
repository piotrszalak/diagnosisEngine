package com.diagnosis.engine.Diseases;

public class OccurringSymptoms {

    private Long symptomId;
    private double probability;

    public OccurringSymptoms(Long symptomId, double probability) {
        this.symptomId = symptomId;
        this.probability = probability;
    }

    public Long getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Long symptomId) {
        this.symptomId = symptomId;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
