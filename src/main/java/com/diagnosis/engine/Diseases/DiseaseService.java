package com.diagnosis.engine.Diseases;

import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class DiseaseService {

    private HashSet<Disease> diseases = new HashSet<>();

    public HashSet<Disease> getStoredDiseases() {
        return diseases;
    }

    public boolean addDisease(Disease disease) {
        if (validateProbability(disease)) {
            disease.setId(diseases.size() + 1L);
            diseases.add(disease);
            return true;
        }
        return false;
    }

    private boolean validateProbability(Disease disease) {
        double probability = disease.getOccurringSymptoms().get(0).getProbability();

        Range<Double> validRange = Range.leftOpen(0D, 1D);
        return (validRange.contains(probability));
    }
}
