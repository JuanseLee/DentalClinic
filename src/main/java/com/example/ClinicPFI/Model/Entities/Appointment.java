package com.example.ClinicPFI.Model.Entities;

import javax.persistence.*;
import lombok.*;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@Entity
@Table(name = "appointments")
public class Appointment {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long Id;
@ManyToOne
@JoinColumn(name = "patient_id",nullable = false)
private Patient patient;

@ManyToOne
@JoinColumn(name = "dentist_id", nullable = false)
private Dentist dentist;

private LocalDate dateAppointment;
private LocalTime timeAppointment;


}
