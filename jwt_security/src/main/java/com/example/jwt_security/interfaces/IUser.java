package com.example.jwt_security.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt_security.models.user;



@Repository
public interface IUser extends CrudRepository<user,String>{

}
