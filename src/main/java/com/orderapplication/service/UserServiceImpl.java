package com.orderapplication.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orderapplication.dto.UserLoginDto;
import com.orderapplication.dto.UserRegistrationDto;
import com.orderapplication.exceptionalhandling.UserNotfoundException;
import com.orderapplication.model.User;
import com.orderapplication.repository.UserRepo;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepository;
	private Random random = new SecureRandom();

	@Override
	public UserLoginDto createUser(UserRegistrationDto userRegistrationDto) {
		
		User user = new User();
		UserLoginDto userLoginDto = new UserLoginDto();
		BeanUtils.copyProperties(userRegistrationDto, user);

		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 10;

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		user.setPassword(generatedString);

		try {
			user = userRepository.save(user);
		} catch (Exception e) {
			
			throw new UserNotfoundException("Email already exists,try another one");
		}

		BeanUtils.copyProperties(user, userLoginDto);

		return userLoginDto;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList =  userRepository.findAll();

		if (userList.isEmpty()) {
			return userList;
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public boolean finduserByEmail(String email) {
		
		User user= userRepository.findByEmail(email);
		if (user != null) {
			if (user.getRole().equalsIgnoreCase("admin")) {
			return true;
			}
			else {
			return false;
			}
		}
		else {
			throw new UserNotfoundException("requested user is not there");
		}
		
	}
	

}
