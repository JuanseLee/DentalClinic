package com.example.ClinicPFI.Model.Dto;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class DentistDto {

    private Long id;


    private String name, lastname;



}
