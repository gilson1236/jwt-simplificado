package com.dio.project.jwtsimplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.dio.project.jwtsimplificado.dto.UserAuthenticateDTO;
import com.dio.project.jwtsimplificado.dto.UserRegistrationDTO;
import com.dio.project.jwtsimplificado.entity.User;
import com.dio.project.jwtsimplificado.mapper.UserMapper;
import com.dio.project.jwtsimplificado.repository.UserRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserRegistrationService {

    private UserRepository userRepository;
    private TokenService tokenService;
    private final UserMapper mapper = UserMapper.INSTANCE;

    public UserAuthenticateDTO registrate(UserRegistrationDTO userRegistrationDTO){

        User userToRegistrate = mapper.toModel(userRegistrationDTO);
        userToRegistrate.setToken(tokenService.generateToken(userToRegistrate));
        User userRegistrated = userRepository.save(userToRegistrate);
        UserAuthenticateDTO userAuthenticated = mapper.toDTOAuthenticated(userRegistrated, "Bearer ");

        return userAuthenticated;
    }
}
