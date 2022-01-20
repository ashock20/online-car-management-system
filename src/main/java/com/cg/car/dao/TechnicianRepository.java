package com.cg.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.car.entity.EvaluationReport;

@Repository
public interface TechnicianRepository extends JpaRepository<EvaluationReport, Integer>{
	
}
