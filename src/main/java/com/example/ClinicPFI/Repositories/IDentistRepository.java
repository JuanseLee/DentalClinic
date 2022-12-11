package com.example.ClinicPFI.Repositories;

import com.example.ClinicPFI.Model.Entities.Dentist;
import com.example.ClinicPFI.Model.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IDentistRepository extends JpaRepository<Dentist, Long> {
    @Query("SELECT d FROM Dentist d WHERE d.id = ?1")
    Dentist findId(Long id);




}
