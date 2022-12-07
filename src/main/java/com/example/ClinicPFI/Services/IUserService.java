package com.example.ClinicPFI.Services;

import com.example.ClinicPFI.Exceptions.BadRequestException;
import com.example.ClinicPFI.Model.Entities.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

     void saveUser (AppUser appUser) throws BadRequestException;

}
