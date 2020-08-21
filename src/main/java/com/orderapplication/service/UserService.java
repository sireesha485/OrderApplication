package com.orderapplication.service;

import java.util.List;

import com.orderapplication.dto.UserLoginDto;
import com.orderapplication.dto.UserRegistrationDto;
import com.orderapplication.model.User;



public interface UserService {

	List<User> getAllUsers();

	UserLoginDto createUser(UserRegistrationDto userRegistrationDto);

	boolean finduserByEmail(String email);
	
}
	

