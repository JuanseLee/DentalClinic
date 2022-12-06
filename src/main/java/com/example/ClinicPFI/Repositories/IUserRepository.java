package com.example.ClinicPFI.Repositories;

import com.example.ClinicPFI.Model.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IUserRepository extends JpaRepository<AppUser, Long> {


}
