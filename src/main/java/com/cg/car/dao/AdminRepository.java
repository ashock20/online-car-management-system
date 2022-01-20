package com.cg.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.car.entity.Technician;

@Repository
public interface AdminRepository extends JpaRepository<Technician, Integer>{
	
}
