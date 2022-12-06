package com.example.ClinicPFI.Repositories;

import com.example.ClinicPFI.Model.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment, Long>{
}
