package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Asignacion;
import com.example.entity.User;

public interface AsignacionRepo extends CrudRepository<Asignacion, Integer> {
	public List<Asignacion> findByUserOrderByJobAsc(User user);

}
