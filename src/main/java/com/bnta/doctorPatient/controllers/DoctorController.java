package com.bnta.doctorPatient.controllers;

import com.bnta.doctorPatient.models.Doctor;
import com.bnta.doctorPatient.repositories.DoctorRepository;
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

    //GET & QUERY
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctorsAndFilters(@RequestParam(required = false, name = "docname") String docname){
        if (docname != null){
            return new ResponseEntity(doctorRepository.findByName(docname), HttpStatus.OK);
        }
        return new ResponseEntity<>(doctorRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id){
        return new ResponseEntity(doctorRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("/new")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor newDoctor){
        Doctor doctor = doctorRepository.save(newDoctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    // DELETE
    // must remove associated patients first
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Long> deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }


}
