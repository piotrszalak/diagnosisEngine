package com.diagnosis.engine.Diagnosis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiagnosisController {

    private DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @PostMapping("/diagnosis")
    public ResponseEntity<?> calculateMostLikelyDisease(@RequestBody Diagnosis diagnosis) {
        try {
            MostProbableDisease mostProbableDisease = diagnosisService.calculateMostProbableDisease(diagnosis);
            return new ResponseEntity<>(mostProbableDisease, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>("Invalid symptoms. All currently stored symptoms are accessible at /symptoms " +
                    "or can be added by sending POST request to /symptoms", HttpStatus.NOT_FOUND);
        }
    }
}

