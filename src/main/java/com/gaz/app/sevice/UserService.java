package com.gaz.app.sevice;

import java.util.List;

import com.gaz.app.entity.User;

public interface UserService {

	User createUser(User user);
	
	User getUserById(Long userId);
	
	List<User> getAllUsers();
	
	User updateUser (User user);
	
	void deleteUser(Long userId);
}
