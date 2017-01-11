package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Asignacion;
import com.example.entity.User;
import com.example.service.AsignacionService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	UserService userService;
	@Autowired
	AsignacionService asignacionService;
	
	    
	
	    
	@RequestMapping("/users")
	public Iterable<User> users(){
		return userService.getAll();
	}
	
	@RequestMapping("/asignacion/{user}")
	public Iterable<Asignacion> getAsignacion(@PathVariable(name="user") String user){
		return asignacionService.getByUser(userService.getById(Integer.parseInt(user)));
	}
	
	
}
