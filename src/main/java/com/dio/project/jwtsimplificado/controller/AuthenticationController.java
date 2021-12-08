package com.dio.project.jwtsimplificado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.dio.project.jwtsimplificado.dto.DadosLogin;
import com.dio.project.jwtsimplificado.dto.UserAuthenticateDTO;
import com.dio.project.jwtsimplificado.service.UserAuthenticationService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationController {

    private UserAuthenticationService userAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticateDTO> autenticar(@RequestBody DadosLogin dadosLogin, 
                                                          @RequestHeader String Authorization){

        UserAuthenticateDTO userAuthenticatedDTO = userAuthenticationService.authenticate(dadosLogin, Authorization);

        return new ResponseEntity<UserAuthenticateDTO>(userAuthenticatedDTO, HttpStatus.ACCEPTED);
    }
}
