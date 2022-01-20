package com.cg.car.service;

import java.util.List;

import com.cg.car.entity.Customer;
import com.cg.car.entity.EvaluationReport;
import com.cg.car.entity.Technician;




public interface AdminService {
	public Technician registerTechnician(Technician technician);
	public Technician updateTechnician(Technician technician);
	public Technician deleteTechnician(int id);
	public Technician getTechnician(int id);
	public List<Technician> getAllTechnicians();
	public Customer blockUser(int id);
	public EvaluationReport getReport(int id);
	public List<EvaluationReport> getAllReports();
}

