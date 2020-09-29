package com.diagnosis.engine.Diseases;

import com.diagnosis.engine.Sex;

import java.util.List;

public class DiseaseDto {

    private String name;
    private Prevalence prevalence;
    private Sex sex;
    private List<OccurringSymptoms> occurringSymptoms;

    public DiseaseDto() {
    }

    public DiseaseDto(String name, Prevalence prevalence, Sex sex, List<OccurringSymptoms> occurringSymptoms) {
        this.name = name;
        this.prevalence = prevalence;
        this.sex = sex;
        this.occurringSymptoms = occurringSymptoms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prevalence getPrevalence() {
        return prevalence;
    }

    public void setPrevalence(Prevalence prevalence) {
        this.prevalence = prevalence;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<OccurringSymptoms> getOccurringSymptoms() {
        return occurringSymptoms;
    }

    public void setOccurringSymptoms(List<OccurringSymptoms> occurringSymptoms) {
        this.occurringSymptoms = occurringSymptoms;
    }
}
