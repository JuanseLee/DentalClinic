package com.example.ClinicPFI.Repositories;

import com.example.ClinicPFI.Model.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
