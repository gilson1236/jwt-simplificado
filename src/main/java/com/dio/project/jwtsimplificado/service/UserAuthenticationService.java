package com.dio.project.jwtsimplificado.service;

import com.dio.project.jwtsimplificado.dto.DadosLogin;
import com.dio.project.jwtsimplificado.entity.User;
import com.dio.project.jwtsimplificado.exception.ExistingEmailException;
import com.dio.project.jwtsimplificado.exception.InvalidLogicException;
import com.dio.project.jwtsimplificado.repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {

    private final UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserAuthenticationService(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User authenticate(DadosLogin dados){
        User user = userRepository.findByEmail(dados.getEmail()).orElseThrow(ExistingEmailException::new);
        if(dados.getSenha().equals(user.getSenha())){
            System.out.println(tokenService.generateToken(user));
            return user;
        } else {
            throw new InvalidLogicException();
        }
    }


}
