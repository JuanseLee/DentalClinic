package com.example.ClinicPFI.Services.ServiceImpl;

import com.example.ClinicPFI.Model.Dto.PatientDto;
import com.example.ClinicPFI.Model.Entities.Patient;
import com.example.ClinicPFI.Repositories.IPatientRepository;
import com.example.ClinicPFI.Services.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientServiceImpl implements IPatientService {
    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void save(PatientDto patientDto) {


        Patient patient =mapper.convertValue(patientDto, Patient.class);

        patientRepository.save(patient);
    }

    @Override
    public Optional<PatientDto> getPatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDto patientDto = null;
        if(patient.isPresent())
            patientDto = mapper.convertValue(patient, PatientDto.class);

        return Optional.ofNullable(patientDto);
    }
    @Override
    public void updatePatientDto(PatientDto patientDto) {
        Patient patient =mapper.convertValue(patientDto, Patient.class);

        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);

    }



    @Override
    public Set<PatientDto> getAll() {

       List<Patient> patients =  patientRepository.findAll();
       Set<PatientDto> patientsDto = new HashSet<>();

       for (Patient patient: patients){
           patientsDto.add(mapper.convertValue(patient,PatientDto.class));
       }

       return patientsDto;
    }
}
