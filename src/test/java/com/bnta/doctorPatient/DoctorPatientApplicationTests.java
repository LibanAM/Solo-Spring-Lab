package com.bnta.doctorPatient;

import com.bnta.doctorPatient.models.Patient;
import com.bnta.doctorPatient.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DoctorPatientApplicationTests {

	@Autowired
	PatientRepository patientRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canFindPatientByAgeGreaterThan(){
		List<Patient> patients = patientRepository.findByAgeGreaterThan(55);
		assertThat(patients.size()).isEqualTo(2);
	}

//	@Test
//	void canFindPatientByAilment(){
//		List<Patient> patients = patientRepository.findByAilment("Broken-foot");
//		assertThat(patients.size()).isEqualTo(1);
//	}

}
