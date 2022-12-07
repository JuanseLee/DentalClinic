package com.example.ClinicPFI.Services.ServiceImpl;

import com.example.ClinicPFI.Exceptions.BadRequestException;
import com.example.ClinicPFI.Model.Entities.AppUser;
import com.example.ClinicPFI.Repositories.IUserRepository;
import com.example.ClinicPFI.Services.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements IUserService {

    private final ObjectMapper mapper = new ObjectMapper();

    public UserServiceImpl(IUserRepository IUserRepository) {
        this.UserRepository = IUserRepository;
    }

    @Autowired
    private IUserRepository UserRepository;


    @Override
    public void saveUser(AppUser appUser) throws BadRequestException {

    }
}
