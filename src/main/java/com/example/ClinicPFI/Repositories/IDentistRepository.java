package com.example.ClinicPFI.Repositories;

import com.example.ClinicPFI.Model.Entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IDentistRepository extends JpaRepository<Dentist, Long> {
}
