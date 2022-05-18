package com.bnta.doctor_patient.models;

import javax.persistence.*;
import java.util.List;

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany
    private List<Patient> patients;
}
