package com.example.ClinicPFI.Services;

import com.example.ClinicPFI.Model.Dto.DentistDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IDentistService  {

    DentistDto saveDentist (DentistDto dentistDto);
    void deleteDentist (Long id);
    void updateDentistDto (DentistDto dentistDto);
    Optional<DentistDto> getDentistDto (Long id);
    Set<DentistDto> getAll();
}
