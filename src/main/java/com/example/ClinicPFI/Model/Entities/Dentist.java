package com.example.ClinicPFI.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
    @Entity
@Table(name="dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name, lastname, registration;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Appointment> appointments;

    public Dentist(String name, String lastname, String registration) {
        this.name = name;
        this.lastname = lastname;
        this.registration = registration;
    }
}
