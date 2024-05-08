package com.example.jwt_security.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt_security.interfaceService.IUserService;
import com.example.jwt_security.interfaces.IUser;
import com.example.jwt_security.models.user;



@Service
public class userService implements IUserService{

	@Autowired
	private IUser data;
	
	@Override
	public String save (user user) {
		data.save(user);
		return user.getId_user();
	}

}
