package com.dio.project.jwtsimplificado.service;

import org.springframework.stereotype.Service;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.dio.project.jwtsimplificado.entity.User;

@Service
public class TokenService {

    //30 minutos
    private static final long expirationTime = 1800000;
    private String key = "String Aleatoria Secret";

    public String generateToken(User user){
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject("Teste Jwt API")
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public Claims decodeToken(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }
}
