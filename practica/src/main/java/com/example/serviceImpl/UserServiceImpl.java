package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.User;
import com.example.repo.UserRepo;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	@Override
	public User getById(Integer id) {
	
		return userRepo.findById(id);
	}
	@Override
	public Iterable<User> getAll() {
		
		return userRepo.findAll();
	}

}
