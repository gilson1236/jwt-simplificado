package com.dio.project.jwtsimplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;

import com.dio.project.jwtsimplificado.dto.DadosLogin;
import com.dio.project.jwtsimplificado.dto.UserAuthenticateDTO;
import com.dio.project.jwtsimplificado.entity.User;
import com.dio.project.jwtsimplificado.exception.ExistingEmailException;
import com.dio.project.jwtsimplificado.exception.ExpiredTokenException;
import com.dio.project.jwtsimplificado.exception.InvalidLogicException;
import com.dio.project.jwtsimplificado.exception.InvalidTokenException;
import com.dio.project.jwtsimplificado.mapper.UserMapper;
import com.dio.project.jwtsimplificado.repository.UserRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserAuthenticationService {

    private UserRepository userRepository;
    private TokenService tokenService;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserAuthenticateDTO authenticate(DadosLogin dados, String token){
        User user = userRepository.findByEmail(dados.getEmail()).orElseThrow(ExistingEmailException::new);
        UserAuthenticateDTO userAuthenticateDTO;
        if(dados.getSenha().equals(user.getSenha()) && !token.isEmpty() && validate(token)){
            userAuthenticateDTO = userMapper.toDTOAuthenticated(user, "Bearer ");
            return userAuthenticateDTO;
        } else {
            throw new InvalidLogicException();
        }
    }

    private boolean validate(String token){
        System.out.println(token);

        try{
            String tokenTratado = token.replace("Bearer ", "");
            Claims claims = tokenService.decodeToken(tokenTratado);

            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());

            //verifica se o token está expirado

            if(claims.getExpiration().before(new Date(System.currentTimeMillis()))){
                throw new ExpiredTokenException();
            }
            System.out.println(claims.getExpiration());

            return true;
        } catch(ExpiredTokenException ex){
            ex.printStackTrace();
            throw ex;
        } catch (Exception e){
            e.printStackTrace();
            throw new InvalidTokenException();
        }
    }


}
