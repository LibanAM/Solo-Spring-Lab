package com.bnta.doctorPatient.repositories;

import com.bnta.doctorPatient.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByName(String name);
}
