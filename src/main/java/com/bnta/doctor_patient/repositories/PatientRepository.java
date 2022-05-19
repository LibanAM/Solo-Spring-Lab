package com.bnta.doctor_patient.repositories;

import com.bnta.doctor_patient.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    void deleteById(Long id);
    List<Patient> findByAgeGreaterThan(int age);
    List<Patient> findByAilment(String ailment);
}
