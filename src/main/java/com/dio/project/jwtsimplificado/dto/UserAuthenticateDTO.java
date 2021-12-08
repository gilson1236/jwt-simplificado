package com.dio.project.jwtsimplificado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthenticateDTO {

    private Long id;
    private String nome;
    private String email;
    private String token;
    private String senha;
    private String tipo;

}
