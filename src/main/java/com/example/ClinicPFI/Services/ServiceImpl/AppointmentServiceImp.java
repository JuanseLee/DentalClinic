package com.example.ClinicPFI.Services.ServiceImpl;

import com.example.ClinicPFI.Model.Dto.AppointmentDto;
import com.example.ClinicPFI.Model.Entities.Appointment;
import com.example.ClinicPFI.Repositories.AppointmentRepository;
import com.example.ClinicPFI.Services.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class AppointmentServiceImp implements IAppointmentService {
    private static final Logger LOGGER = Logger.getLogger(AddressServiceImpl.class);

    @Autowired
    private final AppointmentRepository appointmentRepository;
    @Autowired

    ObjectMapper mapper;

    public AppointmentServiceImp() {
        appointmentRepository = null;
    }

    @Override
    public void save(AppointmentDto appointmentDto) {
        LOGGER.info("Saving Appointment");


        Appointment appointment =mapper.convertValue(appointmentDto, Appointment.class);

        appointmentRepository.save(appointment);
    }

    @Override
    public Optional<AppointmentDto> getAppointmentDto(Long id) {
        LOGGER.info("Saving Appointment");

        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDto appointmentDto = null;
        if(appointment.isPresent())
            appointmentDto = mapper.convertValue(appointment, AppointmentDto.class);

        return Optional.ofNullable(appointmentDto);
    }
    @Override
    public void updateAppointmentDto(AppointmentDto appointmentDto) {
        LOGGER.info("Appointment updated");
        Appointment appointment =mapper.convertValue(appointmentDto, Appointment.class);

        appointmentRepository.save(appointment);;
    }

    @Override
    public void deleteAppointment(Long id) {
        LOGGER.info("Appointment deleted");

        appointmentRepository.deleteById(id);

    }



    @Override
    public Set<AppointmentDto> getAll() {
        LOGGER.info("Get all appointments");


        List<Appointment> appointments =  appointmentRepository.findAll();
        Set<AppointmentDto> appointmentsDto = new HashSet<>();

        for (Appointment appointment: appointments){
            appointmentsDto.add(mapper.convertValue(appointment,AppointmentDto.class));
        }

        return appointmentsDto;
    }
}
