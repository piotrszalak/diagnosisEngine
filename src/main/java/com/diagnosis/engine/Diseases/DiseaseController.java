package com.diagnosis.engine.Diseases;

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
public class DiseaseController {

    private DiseaseService diseaseService;
    private ModelMapper modelMapper;

    @Autowired
    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping("/diseases")
    public ResponseEntity<?> addDisease(@RequestBody DiseaseDto diseaseDto) {
        Disease disease = modelMapper.map(diseaseDto, Disease.class);
        if (diseaseService.addDisease(disease)) {
            return new ResponseEntity<>(disease, HttpStatus.OK);
        }
        return new ResponseEntity<>("Provide valid disease", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/diseases")
    public HashSet<Disease> getStoredDiseases() {
        return diseaseService.getStoredDiseases();
    }

}
