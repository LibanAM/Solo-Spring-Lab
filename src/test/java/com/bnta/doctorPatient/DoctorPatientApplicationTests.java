package com.bnta.doctorPatient;

import com.bnta.doctorPatient.models.Doctor;
import com.bnta.doctorPatient.models.Patient;
import com.bnta.doctorPatient.repositories.DoctorRepository;
import com.bnta.doctorPatient.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.Doc;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DoctorPatientApplicationTests {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canFindPatientByAgeGreaterThanAndAilment(){
		List<Patient> found = patientRepository.findByAgeGreaterThanAndAilment(20, "Broken-foot");
		assertThat(found.size()).isEqualTo(2);
	}
	@Test
	void canFindPatientByAgeGreaterThan(){
		List<Patient> found = patientRepository.findByAgeGreaterThan(55);
		assertThat(found.size()).isEqualTo(2);
	}

	@Test
	void canFindPatientByAilment(){
		List<Patient> found = patientRepository.findByAilment("Broken-foot");
		assertThat(found.size()).isEqualTo(2);
	}

	@Test
	void canFindDoctorByName(){
		List<Doctor> found = doctorRepository.findByName("Fred");
		assertThat(found.size()).isEqualTo(1);
	}

}
