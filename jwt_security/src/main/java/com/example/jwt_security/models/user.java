package com.example.jwt_security.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
	@Entity(name="user")
	public class user {

		@Id	
		@GeneratedValue(strategy = GenerationType.UUID)
		@Column(name="id_user", nullable=false, length = 36)
		private String id_user;
		
		@Column(name="first_name_user",nullable=false,length = 20)
		private String first_name_user;
		
		@Column(name="last_name_user",nullable=false,length = 100)
		private String last_name_user;
		
		@Column(name="email_unique",nullable=false,length = 255)
		private String email_unique;
		
		@Column(name="password",nullable=false,length = 12)
		private String password;

		@Column(name="confirm_password",nullable=false,length = 12)
		private String confirm_password;
		
		@Column(name="number_phone",nullable=false,length = 15)
		private String number_phone;
		
		@Column(name="Rol", nullable=false,length=20)
		private String Rol;

		
		// public user(String id_user, String first_name_user, String last_name_user, String email_unique, String password,
		// 		String confirm_password, String number_phone) {
		// 	super();
		// 	this.id_user = id_user;
		// 	this.first_name_user = first_name_user;
		// 	this.last_name_user = last_name_user;
		// 	this.email_unique = email_unique;
		// 	this.password = password;
		// 	this.confirm_password = confirm_password;
		// 	this.number_phone = number_phone;
		// }

		

		
		
	}

	
