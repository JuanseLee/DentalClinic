package com.example.ClinicPFI.Services;

import com.example.ClinicPFI.Model.Dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

     UserDto save (UserDto userDto);
     void delete ();
     UserDto updateUserDto (UserDto userDto);
     UserDto getUserDto (UserDto userDto);

}
