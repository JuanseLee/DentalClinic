package com.example.ClinicPFI.Model.Entities;

import javax.persistence.*;

@Entity
@Table(name= "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street, number, city, state, postalCode;

    @OneToOne (mappedBy = "address")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
