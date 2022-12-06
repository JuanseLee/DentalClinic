package com.example.ClinicPFI.Services;

import com.example.ClinicPFI.Model.Dto.AppointmentDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IAppointmentService {

    void save (AppointmentDto appointmentDto);
    void deleteAppointment (Long id);
    void updateAppointmentDto (AppointmentDto appointmentDto);
    Optional <AppointmentDto> getAppointmentDto (Long id);
    Set<AppointmentDto> getAll();
}
