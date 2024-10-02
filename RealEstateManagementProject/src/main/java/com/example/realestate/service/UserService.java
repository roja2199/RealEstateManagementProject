package com.example.realestate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mapping.model.Property;
import org.springframework.stereotype.Service;

import com.example.realestate.entity.User;


public interface UserService {
	List<User> getAllUsers();
	Optional<User> getUserById(Long id);
	User addUser(User user);
	User updateUser(Long id,User userDetails);
	void deleteUser(Long id);
	
	

}
