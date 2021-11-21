package com.prueba.spring.evaluacion.business;

import com.prueba.spring.evaluacion.exception.EmailAlreadyExistsException;
import com.prueba.spring.evaluacion.model.db.AuthUser;
import com.prueba.spring.evaluacion.model.request.UserRequest;

public interface AuthUserService {
	
	AuthUser create(UserRequest userRequest) throws EmailAlreadyExistsException;
	
}
