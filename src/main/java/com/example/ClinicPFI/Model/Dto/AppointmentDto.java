package com.example.ClinicPFI.Model.Dto;

import com.example.ClinicPFI.Model.Entities.Dentist;
import com.example.ClinicPFI.Model.Entities.Patient;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString

public class AppointmentDto {

    private Long Id;
     private Dentist dentist;

    private Patient patient;
    private Date dateAppointment;
    private Time timeAppointment;


}