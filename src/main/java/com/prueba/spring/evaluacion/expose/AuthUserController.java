package com.prueba.spring.evaluacion.expose;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.spring.evaluacion.business.AuthUserService;
import com.prueba.spring.evaluacion.exception.EmailAlreadyExistsException;
import com.prueba.spring.evaluacion.model.db.AuthUser;
import com.prueba.spring.evaluacion.model.request.UserRequest;

@RestController
@RequestMapping("/evaluacion/v1/user")
public class AuthUserController {

	@Autowired
	private AuthUserService userService;

	@CrossOrigin(origins = "*")
	@PostMapping(
			path = "/",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public @ResponseBody
	ResponseEntity<?> create(@RequestBody UserRequest request) throws EmailAlreadyExistsException {
		
		Map<String, Object> response = new HashMap<>();
		try {
			
			AuthUser user = userService.create(request);
			return ResponseEntity.ok(user);
		} catch (EmailAlreadyExistsException e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
	}
		

}
