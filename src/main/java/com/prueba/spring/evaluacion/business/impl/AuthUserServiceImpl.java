package com.prueba.spring.evaluacion.business.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prueba.spring.evaluacion.auth.JwtTokenUtil;
import com.prueba.spring.evaluacion.business.AuthUserService;
import com.prueba.spring.evaluacion.exception.EmailAlreadyExistsException;
import com.prueba.spring.evaluacion.model.db.AuthUser;
import com.prueba.spring.evaluacion.model.request.UserRequest;
import com.prueba.spring.evaluacion.repository.AuthUserRepository;

@Service
public class AuthUserServiceImpl implements AuthUserService {

	@Autowired
	private AuthUserRepository userRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public AuthUser create(UserRequest userRequest)
			throws EmailAlreadyExistsException {
		
		Optional<AuthUser> userEmailOpt = userRepository.findByEmail(userRequest.getEmail());
		
		if (userEmailOpt.isPresent()) {
			throw new EmailAlreadyExistsException("El correo ya esta registrado");
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String newPassword = passwordEncoder.encode(userRequest.getPassword());

		final UserDetails userDetails = new User(userRequest.getName(), newPassword, new ArrayList<>());

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		AuthUser user = new AuthUser();

		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(newPassword);
		user.setToken(token);
		user.setIsactive(true);
		user.setCreated(LocalDateTime.now());
		user.setModified(LocalDateTime.now());
		user.setLast_login(LocalDateTime.now());

		user.setUserInfo(userRequest.getPhones());
		userRepository.save(user);
		
		return user;

	}

}
