package com.bnta.doctorPatient.repositories;

import com.bnta.doctorPatient.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByAgeGreaterThan(int age);
    List<Patient> findByAilment(String ailment);
    List<Patient> findByAgeGreaterThanAndAilment(int age, String ailment);



}
