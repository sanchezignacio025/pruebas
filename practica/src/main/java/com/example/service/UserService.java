package com.example.service;



import com.example.entity.User;

public interface UserService {
	public User getById(Integer id);
	public Iterable<User> getAll();

}
