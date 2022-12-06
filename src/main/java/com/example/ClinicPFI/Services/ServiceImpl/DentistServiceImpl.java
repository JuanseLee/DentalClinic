package com.example.ClinicPFI.Services.ServiceImpl;

import com.example.ClinicPFI.Model.Dto.DentistDto;
import com.example.ClinicPFI.Model.Entities.Dentist;
import com.example.ClinicPFI.Repositories.IDentistRepository;
import com.example.ClinicPFI.Services.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service

public class DentistServiceImpl implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void saveDentist(DentistDto dentistDto) {


        Dentist dentist =mapper.convertValue(dentistDto, Dentist.class);

        dentistRepository.save(dentist);
    }

    @Override
    public Optional<DentistDto> getDentistDto(Long id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDto dentistDto = null;
        if(dentist.isPresent())
            dentistDto = mapper.convertValue(dentist, DentistDto.class);

        return Optional.ofNullable(dentistDto);
    }
    @Override
    public void updateDentistDto(DentistDto dentistDto) {
        Dentist dentist =mapper.convertValue(dentistDto, Dentist.class);

        dentistRepository.save(dentist);;
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);

    }



    @Override
    public Set<DentistDto> getAll() {

        List<Dentist> dentists =  dentistRepository.findAll();
        Set<DentistDto> dentistsDto = new HashSet<>();

        for (Dentist dentist: dentists){
            dentistsDto.add(mapper.convertValue(dentist,DentistDto.class));
        }

        return dentistsDto;
    }
}
