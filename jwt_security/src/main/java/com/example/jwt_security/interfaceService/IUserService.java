package com.example.jwt_security.interfaceService;

import org.springframework.stereotype.Service;

import com.example.jwt_security.models.user;



@Service
public interface IUserService {
	public String save(user user);
}
