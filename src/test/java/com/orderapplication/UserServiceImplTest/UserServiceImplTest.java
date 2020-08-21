package com.orderapplication.UserServiceImplTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.orderapplication.dto.UserLoginDto;
import com.orderapplication.dto.UserRegistrationDto;
import com.orderapplication.model.User;
import com.orderapplication.repository.UserRepo;
import com.orderapplication.service.UserServiceImpl;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl useServiceImpl;

	@Mock
	UserRepo userRepo;

	@Test
	public void testCreateUserForPositive() throws Exception {
		User user = new User();
		UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
		UserLoginDto userloginDto = new UserLoginDto();
		

		user.setEmail("kumar@gmail.com");
		user.setGender("male");
		user.setPassword("hjjj");
		user.setPhoneNo("9899999");
		user.setRole("admin");
	//Mockito.when(userService.(userRegistrationDto)).thenReturn(userloginDto);
		when(userRepo.save(Mockito.any(User.class))).thenReturn(user);
		UserLoginDto user1 = useServiceImpl.createUser(userRegistrationDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals("kumar@gmail.com", user1.getEmail());
	}
}