package com.kkulpa.kodillalibrary.mapper;

import com.kkulpa.kodillalibrary.domain.User;
import com.kkulpa.kodillalibrary.domain.UserDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserMapper {

    public User createNewUser(UserDTO userDTO){
            return new User(0,
                    userDTO.getFirstName(),
                    userDTO.getName(),
                    LocalDate.now()
                    );
    }


}
