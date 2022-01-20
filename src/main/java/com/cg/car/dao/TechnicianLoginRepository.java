package com.cg.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.car.entity.Technician;

public interface TechnicianLoginRepository extends JpaRepository<Technician, Integer>{
	public Technician findByuserNameAndPassword(String userName,String password);
}
