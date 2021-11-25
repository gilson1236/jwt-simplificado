package com.dio.project.jwtsimplificado.service;

import com.dio.project.jwtsimplificado.entity.User;
import com.dio.project.jwtsimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;

    @Autowired
    public UserRegistrationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registrate(User user){
        return userRepository.save(user);
    }
}
