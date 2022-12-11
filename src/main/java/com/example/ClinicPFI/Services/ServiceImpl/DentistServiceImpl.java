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
import java.util.logging.Logger;

@Service

public class DentistServiceImpl implements IDentistService {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(DentistServiceImpl.class));
    @Autowired
    private IDentistRepository dentistRepository;

    public DentistServiceImpl(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Autowired
    ObjectMapper mapper;
    @Override
    public DentistDto saveDentist(DentistDto dentistDto) {
        LOGGER.info("Creating dentist");



        Dentist dentist =mapper.convertValue(dentistDto, Dentist.class);

        dentistRepository.save(dentist);
        return dentistDto;
    }

    @Override
    public Optional<DentistDto> getDentistDto(Long id) {
        LOGGER.info("Consulting Dentist");

        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDto dentistDto = null;
        if(dentist.isPresent())
            dentistDto = mapper.convertValue(dentist, DentistDto.class);

        return Optional.ofNullable(dentistDto);
    }
    @Override
    public void updateDentistDto(DentistDto dentistDto) {
        LOGGER.info("Updating Dentist");

        Dentist dentist =mapper.convertValue(dentistDto, Dentist.class);

        dentistRepository.save(dentist);;
    }

    @Override
    public void deleteDentist(Long id) {
        LOGGER.info("Deleting dentist");

        dentistRepository.deleteById(id);

    }



    @Override
    public Set<DentistDto> getAll() {
        LOGGER.info("Getting all dentists");


        List<Dentist> dentists =  dentistRepository.findAll();
        Set<DentistDto> dentistsDto = new HashSet<>();

        for (Dentist dentist: dentists){
            dentistsDto.add(mapper.convertValue(dentist,DentistDto.class));
        }

        return dentistsDto;
    }
}
