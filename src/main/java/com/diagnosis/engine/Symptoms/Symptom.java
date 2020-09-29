package com.diagnosis.engine.Symptoms;

import com.diagnosis.engine.Sex;

import java.util.Objects;

public class Symptom {

    private Long id;
    private String name;
    private Sex sex;

    public Symptom() {
    }

    public Symptom(Long id, String name, Sex sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptom symptom = (Symptom) o;
        return name.equals(symptom.name) &&
                sex == symptom.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }
}
