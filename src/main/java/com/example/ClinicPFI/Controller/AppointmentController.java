package com.example.ClinicPFI.Controller;

import com.example.ClinicPFI.Model.Dto.AppointmentDto;
import com.example.ClinicPFI.Model.Dto.PatientDto;
import com.example.ClinicPFI.Services.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    IAppointmentService appointmentService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto appointmentDto){

        appointmentService.save(appointmentDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<AppointmentDto> getAppointment(@PathVariable Long id){

        return appointmentService.getAppointmentDto(id);
    }

    @GetMapping()
    public Collection<AppointmentDto> getAppointments() {

        return appointmentService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (appointmentService.getAppointmentDto(id).isPresent()){
            appointmentService.deleteAppointment(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @PutMapping
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDto appointmentDto)
    {
        appointmentService.updateAppointmentDto(appointmentDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
