package com.diagnosis.engine.Diagnosis;

public class ReportedSymptoms {

    private Long symptomId;

    public ReportedSymptoms(Long symptomId) {
        this.symptomId = symptomId;
    }

    public Long getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Long symptomId) {
        this.symptomId = symptomId;
    }
}
