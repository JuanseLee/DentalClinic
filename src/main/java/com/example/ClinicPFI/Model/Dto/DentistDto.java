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

    public DentistDto(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
}
