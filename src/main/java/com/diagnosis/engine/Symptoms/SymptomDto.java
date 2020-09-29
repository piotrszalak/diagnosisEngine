package com.diagnosis.engine.Symptoms;

import com.diagnosis.engine.Sex;

public class SymptomDto {

    private String name;
    private Sex sex;


    public SymptomDto(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public SymptomDto() {
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
}
