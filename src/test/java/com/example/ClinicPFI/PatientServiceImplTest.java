package com.example.ClinicPFI;

import com.example.ClinicPFI.Model.Dto.PatientDto;
import com.example.ClinicPFI.Services.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceImplTest {

    @Autowired
    private IPatientService patientService;

    @Test
    public void testSavePatient() {
        PatientDto patientDto = new PatientDto();
        patientDto.setName("Juan");
        patientDto.setLastname("Lozano");
        patientDto.setAdmissionDate(LocalDate.ofEpochDay(20230101));
        patientService.save(patientDto);


        Optional<PatientDto> patientJuan = patientService.getPatient(1L);

        assertTrue(patientJuan != null);

//    }

//    @Test
//    public void testDeletePatient(){
//        PatientDto patientDto = new PatientDto();
//    }
//}
    }
}
