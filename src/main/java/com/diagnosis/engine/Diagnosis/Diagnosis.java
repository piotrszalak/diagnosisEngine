package com.diagnosis.engine.Diagnosis;

import com.diagnosis.engine.Sex;

import java.util.List;

public class Diagnosis {

    private Sex sex;
    private List<Long> reportedSymptoms;

    public Diagnosis(Sex sex, List<Long> reportedSymptoms) {
        this.sex = sex;
        this.reportedSymptoms = reportedSymptoms;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Long> getReportedSymptoms() {
        return reportedSymptoms;
    }

    public void setReportedSymptoms(List<Long> reportedSymptoms) {
        this.reportedSymptoms = reportedSymptoms;
    }


}
