package com.dio.project.jwtsimplificado.dto;

import com.dio.project.jwtsimplificado.entity.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserResponserDTO {

    private Long id;

    private String nome;
    private String email;
    private String senha;

    public static UserResponserDTO toDTO(User user){
        return new UserResponserDTO(user.getId(), user.getNome(), user.getEmail(), user.getSenha());
    }
}
