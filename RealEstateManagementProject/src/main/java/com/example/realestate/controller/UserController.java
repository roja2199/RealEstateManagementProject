package com.example.realestate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.realestate.entity.User;
import com.example.realestate.exceptions.UserNotFoundException;
import com.example.realestate.service.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	// getAllUsers

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
//getUserDetailsById

	@GetMapping("/{id}")
	private User getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
		Optional<User> user = userService.getUserById(id);
		if (user.isPresent())
			return user.get();
		else
			throw new UserNotFoundException("User not found with given id");
	}

	// createUser
	@PostMapping("/add")
	public ResponseEntity<String> userCreation(@Validated @RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("User added sucessfully", new HttpHeaders(), HttpStatus.OK);
	}

	// deleteUser
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		
		return new ResponseEntity<String>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
	}

	// updateUser
	@PutMapping("/updateUser/{id}")

	public ResponseEntity<String> updateUser(@Validated @RequestBody User user, @PathVariable("id") Long id) {
		userService.updateUser(id, user);
		return new ResponseEntity<String>("Updated Successfully", new HttpHeaders(), HttpStatus.OK);
	}

}
