package com.dio.project.jwtsimplificado.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dio.project.jwtsimplificado.dto.UserAuthenticateDTO;
import com.dio.project.jwtsimplificado.dto.UserRegistrationDTO;
import com.dio.project.jwtsimplificado.dto.UserResponserDTO;
import com.dio.project.jwtsimplificado.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", source = "email")
    public User toModel(UserRegistrationDTO userRegistrationDTO);

    @Mapping(target = "email", source = "email")
    public UserResponserDTO toDTO(User user);

    @Mapping(target = "tipo", source = "tipo")
    public UserAuthenticateDTO toDTOAuthenticated(User user, String tipo);
}
