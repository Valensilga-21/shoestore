package com.example.jwt_security.controller.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_security.interfaceService.IUserService;
import com.example.jwt_security.models.user;



@RequestMapping("/api/v1/userPublic")
@RestController
@CrossOrigin
public class userPublicController {

	

}