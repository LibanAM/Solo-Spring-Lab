package com.bnta.doctor_patient.controllers;

import com.bnta.doctor_patient.models.Doctor;
import com.bnta.doctor_patient.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return new ResponseEntity<>(doctorRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id){
        return new ResponseEntity(doctorRepository.findById(id), HttpStatus.OK);
    }
    


}
