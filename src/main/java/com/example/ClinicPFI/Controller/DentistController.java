package com.example.ClinicPFI.Controller;

import com.example.ClinicPFI.Model.Dto.DentistDto;

import com.example.ClinicPFI.Services.IDentistService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    IDentistService dentistService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<?> createDentist(@RequestBody DentistDto dentist){

        dentistService.saveDentist(dentist);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<DentistDto> getDentist(@PathVariable Long id){

        return dentistService.getDentistDto(id);
    }

    @GetMapping()
    public List<DentistDto> getDentists() {
        Set<DentistDto> dentistList = dentistService.getAll();
        List<DentistDto> dentistDtoList = new ArrayList<>();
        DentistDto dentistDto;
        for (DentistDto dentist : dentistList) {
            dentistDto = objectMapper.convertValue(dentist, DentistDto.class);
            dentistDtoList.add(dentistDto);
        }
        return dentistDtoList;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (dentistService.getDentistDto(id).isPresent()){
            dentistService.deleteDentist(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @PutMapping
    public ResponseEntity<?> updateDentist(@RequestBody DentistDto dentistDto)
    {
        dentistService.updateDentistDto(dentistDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
