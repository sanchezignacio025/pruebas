package com.example.service;

import java.util.List;

import com.example.entity.Asignacion;
import com.example.entity.User;

public interface AsignacionService {
	public List<Asignacion> getByUser(User user);

}
