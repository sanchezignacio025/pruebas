package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	public User findById(Integer id);

	
}
