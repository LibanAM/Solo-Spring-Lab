package com.bnta.doctor_patient.models;

import javax.persistence.*;
import java.util.List;

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String email;

    @Column
    private List<String> ailments;

    @ManyToOne
    private Doctor doctor;
}
