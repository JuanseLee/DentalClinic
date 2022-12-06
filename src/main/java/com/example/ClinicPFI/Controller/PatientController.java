package com.example.ClinicPFI.Controller;

import com.example.ClinicPFI.Model.Dto.PatientDto;
import com.example.ClinicPFI.Services.IPatientService;
import com.example.ClinicPFI.Services.ServiceImpl.DentistServiceImpl;
import com.example.ClinicPFI.Services.ServiceImpl.PatientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    IPatientService patientService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody PatientDto patientDto){

        patientService.save(patientDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<PatientDto> getPatient(@PathVariable Long id){

        return patientService.getPatient(id);
    }

    @GetMapping()
    public Collection<PatientDto> getPatients() {

        return patientService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (patientService.getPatient(id).isPresent()){
            patientService.deletePatient(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @PutMapping
    public ResponseEntity<?> updatePatient(@RequestBody PatientDto patientDto)
    {
        patientService.updatePatientDto(patientDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

//    @PutMapping("/update")
//    public ResponseEntity<?> update(@RequestBody PatientDto p) {
//        ResponseEntity<String> response = null;
//
//        if (p.getId() != null && patientService.getPatient(p.getId()).isPresent()) {
//           response = ResponseEntity.ok(patientService.updatePatientDto(p));
//        } else {
//            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return response;
//    }


}
