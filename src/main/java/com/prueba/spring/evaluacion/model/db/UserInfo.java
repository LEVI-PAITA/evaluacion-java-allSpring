package com.prueba.spring.evaluacion.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ev_user_info")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserInfo implements Serializable{

	@Id
	@Column(name = "info_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
    @Column(name = "number")
    private String number;
    
    @Column(name = "city_code")
    private String cityCode;
    
    @Column(name = "country_code")
    private String countryCode;
    
}
