package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Asignacion;
import com.example.entity.User;
import com.example.repo.AsignacionRepo;
import com.example.service.AsignacionService;

public class AsignacionServiceImpl implements AsignacionService {
    @Autowired
    AsignacionRepo asignacionRepo;
	
    @Override
	public List<Asignacion> getByUser(User user) {
		
		return asignacionRepo.findByUserOrderByUsername(user);
	}
	

}
