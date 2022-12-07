package com.example.ClinicPFI.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name, lastname, IDNumber;

    private LocalDate admissionDate;

    public Patient(String name, String lastname, String IDNumber, LocalDate admissionDate) {
        this.name = name;
        this.lastname = lastname;
        this.IDNumber = IDNumber;
        this.admissionDate = admissionDate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    @Column(name="AppointmentFK")
    @JsonIgnore
    private Set<Appointment> appointments;


}
