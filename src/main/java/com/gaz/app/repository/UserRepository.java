package com.gaz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaz.app.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	
}