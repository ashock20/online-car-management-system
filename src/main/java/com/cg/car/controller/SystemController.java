package com.cg.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.car.entity.Admin;
import com.cg.car.entity.Customer;
import com.cg.car.exception.AdminNotFoundException;
import com.cg.car.exception.CustomerNotFoundException;
import com.cg.car.service.SystemService;

@RestController
public class SystemController {
	
	@Autowired
	private SystemService sysService;

	@PostMapping(value = "/registerAdmin")
	public Admin registerAdmin(@RequestBody Admin Admin) {
		return sysService.registerAdmin(Admin);
	}

	@PutMapping(value = "/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin Admin) {
		return sysService.updateAdmin(Admin);
		
	}

	@DeleteMapping(value = "/deleteAdmin/{techId}")
	public Admin deleteAdmin(@PathVariable("techId") int techId) throws AdminNotFoundException {
		return sysService.deleteAdmin(techId);
	}

	@GetMapping(value = "/admin/login/{userName}/{password}")
	public Admin adminLogin(@PathVariable String userName,@PathVariable String password) 
	{
		return sysService.adminLogin(userName,password);
	}


	@GetMapping(value = "/getCustomer/{custId}") 
	public Customer getCustomer(@PathVariable("custId") int custId) throws CustomerNotFoundException,AdminNotFoundException
	{ 
		return sysService.getCustomer(custId); 
	}
	
}
