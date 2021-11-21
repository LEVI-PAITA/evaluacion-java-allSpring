package com.prueba.spring.evaluacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.spring.evaluacion.model.db.AuthUser;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer>{

	Optional<AuthUser> findByEmail(String email);
}
