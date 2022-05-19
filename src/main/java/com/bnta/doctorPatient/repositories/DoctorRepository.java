package com.bnta.doctorPatient.repositories;

import com.bnta.doctorPatient.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    String findByName(String name);
}
