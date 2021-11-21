package com.prueba.spring.evaluacion.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.prueba.spring.evaluacion.auth.JwtTokenUtil;
import com.prueba.spring.evaluacion.business.impl.AuthUserServiceImpl;
import com.prueba.spring.evaluacion.exception.EmailAlreadyExistsException;
import com.prueba.spring.evaluacion.model.db.AuthUser;
import com.prueba.spring.evaluacion.model.db.UserInfo;
import com.prueba.spring.evaluacion.model.request.UserRequest;
import com.prueba.spring.evaluacion.repository.AuthUserRepository;

public class AuthUserServiceTest {
	
	@Mock
	private AuthUserRepository authUserRepository;
	
	@Mock
	private JwtTokenUtil jwtTokenUtil;
	
	@InjectMocks
	private AuthUserServiceImpl authUserService;
	
	private AuthUser authUser;
	private UserInfo userInfo;
	private UserRequest userRequest;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		authUser = new AuthUser();
		authUser.setUserId((long) 1);
		authUser.setCreated(LocalDateTime.now());
		authUser.setModified(LocalDateTime.now());
		authUser.setLast_login(LocalDateTime.now());
		authUser.setIsactive(true);
		authUser.setToken("sajdklajskldjaskldjklas");
		authUser.setEmail("levi@gmail.com");
		
		userInfo = new UserInfo();
		userInfo.setNumber("12345678");
		userInfo.setCityCode("12");
		userInfo.setCountryCode("00084");
		
		userRequest = new UserRequest();
		userRequest.setPassword("prueba0001");
		userRequest.setName("levi");
		userRequest.setEmail("prueba@gmail.com");
		
	}
	
	@Test
	void createAuthUser() throws EmailAlreadyExistsException {
		
		when(authUserRepository.save(any())).thenReturn(authUser);
		when(authUserRepository.findByEmail(any())).thenReturn(Optional.ofNullable(null));
		when(jwtTokenUtil.generateToken(any())).thenReturn("prueba_eval");

		assertNotNull(authUserService.create(userRequest));
		
	}

}
