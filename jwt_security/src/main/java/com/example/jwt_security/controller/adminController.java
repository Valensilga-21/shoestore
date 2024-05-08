package com.example.jwt_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")

public class adminController {

	@GetMapping("/")
	public String home() {
		return "Este es un end point privado del administrador";
	}
	
}