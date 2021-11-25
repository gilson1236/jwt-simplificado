package com.dio.project.jwtsimplificado.mapper;

import com.dio.project.jwtsimplificado.dto.UserRegistrationDTO;
import com.dio.project.jwtsimplificado.dto.UserResponserDTO;
import com.dio.project.jwtsimplificado.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", source = "email")
    public User toModel(UserRegistrationDTO userRegistrationDTO);

    @Mapping(target = "email", source = "email")
    public UserResponserDTO toDTO(User user);
}
