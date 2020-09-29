package com.diagnosis.engine.Symptoms;

import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class SymptomService {

    private HashSet<Symptom> storedSymptoms = new HashSet<>();

    public void addSymptom(Symptom symptom) {
        symptom.setId(storedSymptoms.size() + 1L);
        storedSymptoms.add(symptom);
    }

    public HashSet<Symptom> getSymptoms() {
        return storedSymptoms;
    }


}
