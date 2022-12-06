package com.example.ClinicPFI.Model.Dto;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@ToString
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class PatientDto {


    @Id
    private Long id;

    private String name, lastname, address;

    private LocalDate admissionDate;

}
