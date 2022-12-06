package com.example.ClinicPFI;

import com.example.ClinicPFI.Model.Dto.DentistDto;
import com.example.ClinicPFI.Model.Entities.Dentist;
import com.example.ClinicPFI.Services.IDentistService;
import com.example.ClinicPFI.Services.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DentistServiceImplTest {
    @Autowired
    private IDentistService dentistService;
    @Test
    public void testSaveDentist(){
        DentistDto dentistDto = new DentistDto();
        dentistDto.setName("Juan");
        dentistDto.setLastname("Lozano");
        dentistService.saveDentist(dentistDto);


        Optional<DentistDto> dentistJuan = dentistService.getDentistDto(1L);

        assertTrue(dentistJuan !=null);

    }

    @Test
    void getDentistDto() {
    }

    @Test
    void updateDentistDto() {
    }

    @Test
    void deleteDentist() {
    }

    @Test
    void getAll() {
    }
}