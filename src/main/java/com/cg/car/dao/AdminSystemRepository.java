package com.cg.car.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.car.entity.Admin;

public interface AdminSystemRepository extends JpaRepository<Admin, Integer>{
	Optional<Admin> findByuserNameAndPassword(String userName, String password);
}
