package com.bnta.doctor_patient.repositories;

import com.bnta.doctor_patient.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
