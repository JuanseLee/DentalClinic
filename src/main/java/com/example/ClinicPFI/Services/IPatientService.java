package com.example.ClinicPFI.Services;

import com.example.ClinicPFI.Model.Dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IPatientService {

    void save (PatientDto patient);
    void deletePatient (Long id);
    void updatePatientDto (PatientDto patientDto);
    Optional <PatientDto> getPatient (Long id);
    Set<PatientDto> getAll();
}
