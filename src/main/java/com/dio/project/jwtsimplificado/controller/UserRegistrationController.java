package com.dio.project.jwtsimplificado.controller;

import com.dio.project.jwtsimplificado.dto.UserRegistrationDTO;
import com.dio.project.jwtsimplificado.dto.UserResponserDTO;
import com.dio.project.jwtsimplificado.entity.User;
import com.dio.project.jwtsimplificado.mapper.UserMapper;
import com.dio.project.jwtsimplificado.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponserDTO> registrate(@RequestBody UserRegistrationDTO userRegistrationDTO){
        User userToRegistrate = mapper.toModel(userRegistrationDTO);
        User user = userRegistrationService.registrate(userToRegistrate);
        UserResponserDTO userResponser = mapper.toDTO(user);
        return new ResponseEntity<UserResponserDTO>(userResponser, HttpStatus.CREATED);
    }
}
