package com.example.jwt_security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_security.interfaceService.IUserService;
import com.example.jwt_security.models.user;

@RestController
@RequestMapping("/api/v1/public/user")
@CrossOrigin
public class userController {
	
	@Autowired(required=true)
	private IUserService userService;
	

	@GetMapping("/")
	public String home() {
		return "Este es un end point Público";
	}
	
    /*crera los metodos de login y register*/
	@PostMapping("/")
	public ResponseEntity<Object> save(@RequestBody @ModelAttribute("user") user user){	
		System.out.println(user);
		if (user.getFirst_name_user().equals("")) {

            return new ResponseEntity<>("El campo primer nombre es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
		
		if (user.getLast_name_user().equals("")) {

            return new ResponseEntity<>("El campo apellidos es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
		
		if (user.getEmail_unique().equals("")) {

            return new ResponseEntity<>("El campo correo es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
		
		if (user.getPassword().equals("")) {

            return new ResponseEntity<>("El campo contraseña es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
		
		if (user.getConfirm_password().equals("")) {

            return new ResponseEntity<>("El campo confirmar contraseña es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
		
		if (user.getNumber_phone().equals("")) {

            return new ResponseEntity<>("El campo numero de telefono es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
		
		if (user.getRol().equals("")) {

            return new ResponseEntity<>("El rol es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
		
		userService.save(user);
		return new ResponseEntity<>(user,HttpStatus.OK);

	}
	
	
}
