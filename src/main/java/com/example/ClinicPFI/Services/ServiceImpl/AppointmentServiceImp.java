package com.example.ClinicPFI.Services.ServiceImpl;

import com.example.ClinicPFI.Model.Dto.AppointmentDto;
import com.example.ClinicPFI.Model.Entities.Appointment;
import com.example.ClinicPFI.Repositories.AppointmentRepository;
import com.example.ClinicPFI.Services.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class AppointmentServiceImp implements IAppointmentService {
    @Autowired
    private final AppointmentRepository appointmentRepository;
    @Autowired

    ObjectMapper mapper;

    public AppointmentServiceImp() {
        appointmentRepository = null;
    }

    @Override
    public void save(AppointmentDto appointmentDto) {


        Appointment appointment =mapper.convertValue(appointmentDto, Appointment.class);

        appointmentRepository.save(appointment);
    }

    @Override
    public Optional<AppointmentDto> getAppointmentDto(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDto appointmentDto = null;
        if(appointment.isPresent())
            appointmentDto = mapper.convertValue(appointment, AppointmentDto.class);

        return Optional.ofNullable(appointmentDto);
    }
    @Override
    public void updateAppointmentDto(AppointmentDto appointmentDto) {
        Appointment appointment =mapper.convertValue(appointmentDto, Appointment.class);

        appointmentRepository.save(appointment);;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);

    }



    @Override
    public Set<AppointmentDto> getAll() {

        List<Appointment> appointments =  appointmentRepository.findAll();
        Set<AppointmentDto> appointmentsDto = new HashSet<>();

        for (Appointment appointment: appointments){
            appointmentsDto.add(mapper.convertValue(appointment,AppointmentDto.class));
        }

        return appointmentsDto;
    }
}
