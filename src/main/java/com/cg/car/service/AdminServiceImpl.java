package com.cg.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.car.dao.AdminRepository;
import com.cg.car.dao.CustomerRepository;
import com.cg.car.dao.TechnicianRepository;
import com.cg.car.entity.Customer;
import com.cg.car.entity.EvaluationReport;
import com.cg.car.entity.Technician;
import com.cg.car.exception.CustomerNotFoundException;
import com.cg.car.exception.EvaluationReportNotFoundException;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private TechnicianRepository techRepo;
	
	@Override
	public Technician registerTechnician(Technician technician) {
		// TODO Auto-generated method stub
		return adminRepo.save(technician);
	}

	@Override
	public Technician updateTechnician(Technician technician) {
		// TODO Auto-generated method stub
		return adminRepo.save(technician);
	}

	@Override
	public Technician deleteTechnician(int technicianId) {
		// TODO Auto-generated method stub
		Optional<Technician> existingTechnician = adminRepo.findById(technicianId);
		
		Technician technician = null;
		if(existingTechnician.isPresent()) {
			adminRepo.deleteById(technicianId);
			technician = existingTechnician.get();
		}else {
			throw new CustomerNotFoundException("No such Technician!! Check Id");
		}
		return technician;
	}

	@Override
	public Technician getTechnician(int technicianId) {
		// TODO Auto-generated method stub
		Optional<Technician> existingTechnician = adminRepo.findById(technicianId);
		
		Technician technician = null;
		if(existingTechnician.isPresent()) 
		{
			technician = existingTechnician.get();
		}else 
		{
			throw new CustomerNotFoundException("No such Technician!! Check Id");
		}
		return technician;
	}

	@Override
	public List<Technician> getAllTechnicians() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public Customer blockUser(int custId) {
		// TODO Auto-generated method stub
		Optional<Customer> existingCustomer = custRepo.findById(custId);
		
		Customer customer = null;
		if(existingCustomer.isPresent()) 
		{
			customer = existingCustomer.get();
			customer.setCanTrade(false);
		}
		else 
		{
			throw new CustomerNotFoundException("No such Customer");
		}
		return customer;
	}

	@Override
	public EvaluationReport getReport(int reportId) {
		// TODO Auto-generated method stub
		Optional<EvaluationReport> existingReport = techRepo.findById(reportId);
		
		EvaluationReport report = null;
		if(existingReport.isPresent()) 
		{
			report = existingReport.get();
		}
		else 
		{
			throw new EvaluationReportNotFoundException("No such Report Found");
		}
		return report;
	}

	@Override
	public List<EvaluationReport> getAllReports() {
		// TODO Auto-generated method stub
		return techRepo.findAll();
	}
	
	
}
