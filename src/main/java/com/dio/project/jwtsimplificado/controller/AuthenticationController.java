package com.dio.project.jwtsimplificado.controller;

import com.dio.project.jwtsimplificado.dto.DadosLogin;
import com.dio.project.jwtsimplificado.dto.UserResponserDTO;
import com.dio.project.jwtsimplificado.entity.User;
import com.dio.project.jwtsimplificado.mapper.UserMapper;
import com.dio.project.jwtsimplificado.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private UserAuthenticationService userAuthenticationService;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public AuthenticationController(UserAuthenticationService userAuthenticationService){
        this.userAuthenticationService = userAuthenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponserDTO> autenticar(@RequestBody DadosLogin dadosLogin){
        User user = userAuthenticationService.authenticate(dadosLogin);
        UserResponserDTO userResponseDTO = userMapper.toDTO(user);
        return new ResponseEntity<UserResponserDTO>(userResponseDTO, HttpStatus.CREATED);
    }
}
