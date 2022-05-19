package com.bnta.doctor_patient.components;

import com.bnta.doctor_patient.models.Doctor;
import com.bnta.doctor_patient.models.Patient;
import com.bnta.doctor_patient.repositories.DoctorRepository;
import com.bnta.doctor_patient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Doctor doctor1 = new Doctor("Dr.John");
        Doctor doctor2 = new Doctor("Dr.Amy");
        Doctor doctor3 = new Doctor("Dr.Andy");
        doctorRepository.saveAll(Arrays.asList(doctor1, doctor2, doctor3));

        Patient patient1 = new Patient("John Doe", 27, "johndoe27@gmail.com", "Broken-foot", doctor1);
        Patient patient2 = new Patient("Jane Doe", 55, "janedoe55@outlook.com", "Flu-like-symptoms", doctor1);
        Patient patient3 = new Patient("Mike Myers", 58, "halloween1978@outlook.com", "Persistent-cough", doctor1);
        Patient patient4 = new Patient("Jason Voorhees", 75, "jvoorhees@yahoo.com", "Crippling-migraines", doctor2);
        Patient patient5 = new Patient("Chucky Ray", 19, "chuckythedoll@aol.com", "Sprained-ankle", doctor2);
        Patient patient6 = new Patient("Barack Obama", 44, "POTUS44@aol.com", "Back-pain", doctor3);
        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3, patient4, patient5, patient6));

    }
}
