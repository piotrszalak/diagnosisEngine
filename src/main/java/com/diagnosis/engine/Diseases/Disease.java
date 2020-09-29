package com.diagnosis.engine.Diseases;

import com.diagnosis.engine.Sex;

import java.util.List;
import java.util.Objects;

public class Disease {

    private Long id;
    private String name;
    private Prevalence prevalence;
    private Sex sex;
    private List<OccurringSymptoms> occurringSymptoms;


    public Disease() {
    }

    public Disease(Long id, String name, Prevalence prevalence, Sex sex, List<OccurringSymptoms> occurringSymptoms) {
        this.id = id;
        this.name = name;
        this.prevalence = prevalence;
        this.sex = sex;
        this.occurringSymptoms = occurringSymptoms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return name.equals(disease.name) &&
                sex == disease.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }
}
