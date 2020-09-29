package com.diagnosis.engine.Symptoms;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class SymptomController {

    private SymptomService symptomService;
    private ModelMapper modelMapper;

    @Autowired
    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping("/symptoms")
    public ResponseEntity<?> addSymptoms(@RequestBody SymptomDto symptomDto) {
        Symptom symptom = modelMapper.map(symptomDto, Symptom.class);
        if (symptom != null) {
            symptomService.addSymptom(symptom);
            return new ResponseEntity<>(symptom, HttpStatus.OK);
        }
        return new ResponseEntity<>("Please validate provided data", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/symptoms")
    public HashSet<Symptom> getSymptoms() {
        return symptomService.getSymptoms();
    }

}