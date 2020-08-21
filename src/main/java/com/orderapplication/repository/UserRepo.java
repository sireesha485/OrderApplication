package com.orderapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orderapplication.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
}
