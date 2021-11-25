package com.dio.project.jwtsimplificado.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.dio.project.jwtsimplificado.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
