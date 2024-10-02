package com.example.realestate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realestate.entity.User;
import com.example.realestate.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {

		return userRepository.findById(id);
	}

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User updateUser( Long id,User userDetails) {
		User user=userRepository.findById(id).get();
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

}
