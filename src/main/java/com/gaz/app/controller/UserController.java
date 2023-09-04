package com.gaz.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaz.app.entity.User;
import com.gaz.app.sevice.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class UserController {

	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<User> createUSer(@RequestBody User user) {
		User savedUser = userService.createUser(user);
		return ResponseEntity.ok(savedUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
		User user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = userService.getAllUsers();

		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable("id") Long userId,
            @RequestBody User user) 
	{
		user.setId(userId); // <----*****
		User updateUser = userService.updateUser(user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUser
	(@PathVariable("id") Long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>
		("Delete by Id Succefully", HttpStatus.OK);
	}

}
