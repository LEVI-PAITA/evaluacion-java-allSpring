package com.prueba.spring.evaluacion.model.db;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "ev_auth_user")
@Data
public class AuthUser implements Serializable{

	@Id
	@Column(name = "uuid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
    @Column(name = "name")
    @JsonIgnore
    private String name;
    
    @Email(message = "no es una dirección de correo bien formada")
    @Column(name = "email")
    @JsonIgnore
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;
    
    @Column(name = "created")
    private LocalDateTime created;
    
    @Column(name = "modified")
    private LocalDateTime modified;
    
    @Column(name = "last_login")
    private LocalDateTime last_login;
    
    @Column(name = "token")
    private String token;
    
    @Column(name = "isactive")
    private Boolean isactive;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid")
    @JsonIgnore
    private List<UserInfo> userInfo;
    
    
}
