package com.example.ClinicPFI.Services.ServiceImpl;

import com.example.ClinicPFI.Model.Dto.UserDto;
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
    public UserDto save(UserDto UserDto) {

        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public UserDto updateUserDto(UserDto UserDto) {
        return null;
    }

    @Override
    public UserDto getUserDto(UserDto UserDto) {
        return null;
    }
}
