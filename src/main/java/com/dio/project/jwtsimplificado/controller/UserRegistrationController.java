package com.dio.project.jwtsimplificado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.dio.project.jwtsimplificado.dto.UserAuthenticateDTO;
import com.dio.project.jwtsimplificado.dto.UserRegistrationDTO;
import com.dio.project.jwtsimplificado.service.UserRegistrationService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @PostMapping("/user")
    public ResponseEntity<UserAuthenticateDTO> registrate(@RequestBody UserRegistrationDTO userRegistrationDTO){

        UserAuthenticateDTO userAuthenticated = userRegistrationService.registrate(userRegistrationDTO);
        return new ResponseEntity<UserAuthenticateDTO>(userAuthenticated, HttpStatus.CREATED);
    }
}
