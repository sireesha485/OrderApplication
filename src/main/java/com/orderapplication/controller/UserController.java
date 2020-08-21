package com.orderapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderapplication.service.UserService;
import com.orderapplication.dto.UserLoginDto;
import com.orderapplication.dto.UserRegistrationDto;
import com.orderapplication.model.User;



@RestController
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping(value = "/user")
	public ResponseEntity<Object> addUser(@RequestBody UserRegistrationDto userRegistrationDto) {
		
		 UserLoginDto userLoginDto = userService.createUser(userRegistrationDto);
		return new ResponseEntity<>(userLoginDto, HttpStatus.OK);

	}

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}
