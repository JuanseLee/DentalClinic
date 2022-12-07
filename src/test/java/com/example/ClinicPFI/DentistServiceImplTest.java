package com.example.ClinicPFI;

import com.example.ClinicPFI.Exceptions.ResourceNotFoundException;
import com.example.ClinicPFI.Model.Dto.DentistDto;
import com.example.ClinicPFI.Model.Entities.Dentist;
import com.example.ClinicPFI.Services.IDentistService;
import com.example.ClinicPFI.Services.IPatientService;
import com.example.ClinicPFI.Services.ServiceImpl.DentistServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DentistServiceImplTest {
    @Autowired
    private static IDentistService dentistService;


    @Test
    public void testSaveDentist() {
        DentistDto dentistDto = new DentistDto();
        dentistDto.setName("Juan");
        dentistDto.setLastname("Lozano");
        dentistService.saveDentist(dentistDto);


        Optional<DentistDto> dentistJuan = dentistService.getDentistDto(2L);

        assertTrue(dentistJuan != null);
    }

    @Test
    public void guardarDentist() {
        DentistDto dentist = dentistService.saveDentist(new DentistDto("Juan","Lozano"));
        Assert.assertTrue(dentist.getId() != null);

    }

    @Test
    public void eliminarPacienteTest() throws ResourceNotFoundException {
        dentistService.deleteDentist(1L);
        Assert.assertTrue(dentistService.getDentistDto(1L) == null);

    }

    @Test
    public void traerTodos() {
        Set<DentistDto> dentists = dentistService.getAll();
        Assert.assertTrue(!dentists.isEmpty());
        Assert.assertTrue(dentists.size() > 0);
        System.out.println(dentists);
    }


    @Test
    void updateDentistDto() {
    }

}
