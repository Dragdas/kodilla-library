package com.kkulpa.kodillalibrary.controllers.user;


import com.kkulpa.kodillalibrary.domain.User;
import com.kkulpa.kodillalibrary.domain.UserDTO;
import com.kkulpa.kodillalibrary.mapper.UserMapper;
import com.kkulpa.kodillalibrary.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserDbService userDbService;
    private final UserMapper userMapper;


    @GetMapping
    public ResponseEntity<List<User>> getUsers(){

        return ResponseEntity.ok(userDbService.getAllUsers());

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser (@RequestBody UserDTO userDTO){
        User user = userMapper.createNewUser(userDTO);
        userDbService.saveUser(user);
        return ResponseEntity.ok().build();
    }


}
