package com.example.ClinicPFI.Services;

import com.example.ClinicPFI.Model.Dto.DentistDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IDentistService  {

    void saveDentist (DentistDto patientDto);
    void deleteDentist (Long id);
    void updateDentistDto (DentistDto patientDto);
    Optional<DentistDto> getDentistDto (Long id);
    Set<DentistDto> getAll();
}
