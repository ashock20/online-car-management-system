package com.cg.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.car.entity.Customer;
import com.cg.car.entity.Technician;
import com.cg.car.exception.TechnicianNotFoundException;
import com.cg.car.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/registerTechnician")
	public Technician registerTechnician(@RequestBody Technician technician) {
		return adminService.registerTechnician(technician);
	}
	
	@PutMapping(value = "/updateTechnician")
	public Technician updateTechnician(@RequestBody Technician technician) {
		return adminService.updateTechnician(technician);
	}
	
	@DeleteMapping(value = "/deleteTechnician/{techId}")
	public Technician deleteTechnician(@PathVariable("techId") int techId) throws TechnicianNotFoundException {
		return adminService.deleteTechnician(techId);
	}
	
	@GetMapping(value = "/getTechnician/{techId}")
	public Technician getTechnician(@PathVariable("techId") int techId) throws TechnicianNotFoundException{
		return adminService.getTechnician(techId);
	}
	
	@GetMapping(value = "/getAllTechnician")
	public List<Technician> getAllTechnicians() {
		return adminService.getAllTechnicians();
	}
	
	@PutMapping(value = "/blockUser/{custId}")
	public Customer blockUser(@PathVariable("custId") int custId) {
		return adminService.blockUser(custId);
	}
	
}
