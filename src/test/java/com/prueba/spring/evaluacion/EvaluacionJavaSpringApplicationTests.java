package com.prueba.spring.evaluacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.spring.evaluacion.business.impl.AuthUserServiceImpl;
import com.prueba.spring.evaluacion.exception.EmailAlreadyExistsException;
import com.prueba.spring.evaluacion.expose.AuthUserController;
import com.prueba.spring.evaluacion.model.db.AuthUser;
import com.prueba.spring.evaluacion.model.db.UserInfo;
import com.prueba.spring.evaluacion.model.request.UserRequest;

@SuppressWarnings("unchecked")
class EvaluacionJavaSpringApplicationTests {

	@InjectMocks
    private AuthUserController authUserController;
	
	@Mock
	private AuthUserServiceImpl authUserService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    void saveControllerUser() throws EmailAlreadyExistsException {
				
		UserRequest request = new UserRequest();
		request.setName("Levi");
		request.setEmail("levip@gmail.com");
		request.setPassword("prueba1");
		
		ArrayList<UserInfo> userPhoneList = new ArrayList<>();
		
		UserInfo requestPhone = new UserInfo();
		requestPhone.setNumber("1234567");
		requestPhone.setCityCode("0001");
		requestPhone.setCountryCode("0088");
		userPhoneList.add(requestPhone);
		
		request.setPhones(userPhoneList);
		
		AuthUser response = new AuthUser();
		response.setUserId((long) 1);
		response.setCreated(LocalDateTime.now());
		response.setModified(LocalDateTime.now());
		response.setLast_login(LocalDateTime.now());
		response.setIsactive(true);
		response.setToken("sajdklajskldjaskldjklas");
		

        when(authUserService.create(request)).thenReturn(response);

        ResponseEntity<?> httpresponse = authUserController.create(request);
        
        assertEquals(httpresponse.getStatusCode(), HttpStatus.OK);
        
    }

}
