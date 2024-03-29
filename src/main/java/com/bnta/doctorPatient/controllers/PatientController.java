package com.bnta.doctorPatient.controllers;

import com.bnta.doctorPatient.models.Patient;
import com.bnta.doctorPatient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    //GET & QUERY
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatientsAndFilters(@RequestParam(required = false, name = "age") Integer age,
                                                                  @RequestParam(required = false, name = "ailment") String ailment) {

        if (age != null && ailment != null) {
            return new ResponseEntity(patientRepository.findByAgeGreaterThanAndAilment(age, ailment), HttpStatus.OK);
        }
        if (ailment != null && age == null) {
            return new ResponseEntity<>(patientRepository.findByAilment(ailment), HttpStatus.OK);
        }
        if (age != null && ailment == null){
            return new ResponseEntity<>(patientRepository.findByAgeGreaterThan(age), HttpStatus.OK);
        }
        return new ResponseEntity<>(patientRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return new ResponseEntity(patientRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("/new")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient newPatient) {
        Patient patient = patientRepository.save(newPatient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Long> deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }
}
