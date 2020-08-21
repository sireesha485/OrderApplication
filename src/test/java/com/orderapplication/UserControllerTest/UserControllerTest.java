package com.orderapplication.UserControllerTest;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.orderapplication.controller.UserController;
import com.orderapplication.dto.UserDTO;
import com.orderapplication.dto.UserLoginDto;
import com.orderapplication.dto.UserRegistrationDto;
import com.orderapplication.model.User;
import com.orderapplication.service.UserService;





@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Test
	public void testCreateUserForPositive() throws Exception {
		User user = new User();
		UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
		UserLoginDto userloginDto = new UserLoginDto();
		Mockito.when(userService.createUser(userRegistrationDto)).thenReturn(userloginDto);
		ResponseEntity<Object> user1 = userController.addUser(userRegistrationDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	}

	@Test
	public void testCreateUserForNegative() throws Exception {
		User user = new User();
		UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
		UserLoginDto userloginDto = new UserLoginDto();
		Mockito.when(userService.createUser(userRegistrationDto)).thenReturn(userloginDto);
		ResponseEntity<Object> user1 = userController.addUser(userRegistrationDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	}


	
	
}
