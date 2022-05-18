package com.bnta.doctor_patient.repositories;

import com.bnta.doctor_patient.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
