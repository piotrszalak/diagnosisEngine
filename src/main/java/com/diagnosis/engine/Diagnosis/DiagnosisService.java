package com.diagnosis.engine.Diagnosis;

import com.diagnosis.engine.Diseases.Disease;
import com.diagnosis.engine.Diseases.DiseaseService;
import com.diagnosis.engine.Diseases.OccurringSymptoms;
import com.diagnosis.engine.Diseases.Prevalence;
import com.diagnosis.engine.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DiagnosisService {

    private DiseaseService diseaseService;

    @Autowired
    public DiagnosisService(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    public MostProbableDisease calculateMostProbableDisease(Diagnosis diagnosis) {
        Map<Disease, Double> probabilitiesSumMap = new HashMap<>();

        for (Disease relevantDisease : getRelevantDiseases(diagnosis.getSex())) {
            probabilitiesSumMap.put(relevantDisease,
                    probabilitiesSum(relevantSymptoms(getRelevantDiseaseOccurringSymptoms(relevantDisease), getReportedSymptoms(diagnosis))));
        }
        Disease disease = diseaseLikelihood(probabilitiesSumMap);

        return new MostProbableDisease(disease.getId(), disease.getName());
    }

    private List<Disease> getRelevantDiseases(Sex sex) {
        return diseaseService.getStoredDiseases()
                .stream()
                .filter(x -> x.getSex().equals(sex) || x.getSex().equals(Sex.BOTH))
                .collect(Collectors.toList());
    }

    private List<OccurringSymptoms> getRelevantDiseaseOccurringSymptoms(Disease disease) {
        return disease.getOccurringSymptoms();
    }

    private List<Long> getReportedSymptoms(Diagnosis diagnosis) {
        return diagnosis.getReportedSymptoms();
    }

    private List<OccurringSymptoms> relevantSymptoms(List<OccurringSymptoms> occurringSymptoms, List<Long> reportedSymptoms) {
        return occurringSymptoms.stream()
                .filter(occurringSymptom -> reportedSymptoms.stream()
                        .anyMatch(reportedSymptom -> reportedSymptom.equals(occurringSymptom.getSymptomId())))
                .collect(Collectors.toList());
    }

    private double probabilitiesSum(List<OccurringSymptoms> relevantSymptoms) {
        return relevantSymptoms.stream()
                .map(OccurringSymptoms::getProbability)
                .reduce(0D, Double::sum);
    }

    private Disease diseaseLikelihood(Map<Disease, Double> probabilitiesSum) {
        Map<Disease, Double> diseaseLikelihood = new HashMap<>();

        for (Map.Entry<Disease, Double> probabilitySum : probabilitiesSum.entrySet()) {
            Double prevalence = mapPrevalenceToValues(probabilitySum.getKey().getPrevalence());
            diseaseLikelihood.put(probabilitySum.getKey(), prevalence * probabilitySum.getValue());
        }
        List<Disease> mostProbableDiseases = diseaseLikelihood.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(Collections.max(diseaseLikelihood.values())))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return mostProbableDiseases.get(0);
    }

    private Double mapPrevalenceToValues(Prevalence prevalence) {
        Map<Prevalence, Double> prevalenceValues = new HashMap<>();

        prevalenceValues.put(Prevalence.RARE, 0.0005);
        prevalenceValues.put(Prevalence.MODERATE, 0.005);
        prevalenceValues.put(Prevalence.LIKELY, 0.03);

        return prevalenceValues.get(prevalence);
    }
}
