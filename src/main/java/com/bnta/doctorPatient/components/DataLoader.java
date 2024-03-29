package com.bnta.doctorPatient.components;

import com.bnta.doctorPatient.models.Doctor;
import com.bnta.doctorPatient.models.Patient;
import com.bnta.doctorPatient.repositories.DoctorRepository;
import com.bnta.doctorPatient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public DataLoader(){
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Doctor doctor1 = new Doctor("Fred");
        Doctor doctor2 = new Doctor("Anna");
        Doctor doctor3 = new Doctor("Emily");
        doctorRepository.saveAll(Arrays.asList(doctor1, doctor2, doctor3));

        Patient patient1 = new Patient("John Doe", 27, "johndoe27@gmail.com", "Broken-foot", doctor1);
        Patient patient2 = new Patient("Jane Doe", 55, "janedoe55@outlook.com", "Flu-like-symptoms", doctor1);
        Patient patient3 = new Patient("Mike Myers", 58, "halloween1978@outlook.com", "Persistent-cough", doctor1);
        Patient patient4 = new Patient("Jason Voorhees", 75, "jvoorhees@yahoo.com", "Broken-foot", doctor2);
        Patient patient5 = new Patient("Chucky Ray", 19, "chuckythedoll@aol.com", "Sprained-ankle", doctor2);
        Patient patient6 = new Patient("Barack Obama", 44, "POTUS44@aol.com", "Broken-foot", doctor3);
        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3, patient4, patient5, patient6));

    }
}
