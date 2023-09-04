package com.gaz.app.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.gaz.app.entity.User;
import com.gaz.app.repository.UserRepository;
import com.gaz.app.sevice.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
	
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
	Optional<User> optionalUser =	userRepository.findById(userId);
		return  optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
	
		User userUpdate = userRepository.findById(user.getId()).get();// <----***
		userUpdate.setFirstName(user.getFirstName());
		userUpdate.setLastName(user.getLastName());
		userUpdate.setEmail(user.getEmail());
		User updateUsuario = userRepository.save(userUpdate);
	
		return updateUsuario;
	}

	@Override
	public void deleteUser(Long userId) {
	 userRepository.deleteById(userId);
		
	}

}
