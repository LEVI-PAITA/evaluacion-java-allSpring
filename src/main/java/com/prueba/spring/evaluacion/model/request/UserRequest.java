package com.prueba.spring.evaluacion.model.request;

import java.util.List;

import com.prueba.spring.evaluacion.model.db.UserInfo;

import lombok.Data;

@Data
public class UserRequest {

	private String name;
	
	private String email;
	
	private String password;
	
	private List<UserInfo> phones;
	
}
