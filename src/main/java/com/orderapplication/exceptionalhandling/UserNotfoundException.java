package com.orderapplication.exceptionalhandling;

public class UserNotfoundException extends RuntimeException {

	public UserNotfoundException(String message) {
		super(message);
	}
	
}