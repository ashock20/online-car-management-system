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

import com.cg.car.entity.Car;
import com.cg.car.entity.Customer;
import com.cg.car.entity.Transaction;
import com.cg.car.exception.CustomerNotFoundException;
import com.cg.car.exception.CustomerNotLoggedInException;
import com.cg.car.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/registerCustomer")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return customerService.registerCustomer(customer);
	}
	
	@PutMapping(value = "/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping(value = "/deleteCustomer/{id}")
	public Customer deleteCustomer(@PathVariable("id") int custId) throws CustomerNotFoundException {
		return customerService.deleteCustomer(custId);
	}
	
	@GetMapping(value = "/getAllCustomers")
	public List<Customer> getCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping(value = "login/{userName}/{password}")
	public Customer login(@PathVariable String userName,@PathVariable String password) 
	{
		return customerService.login(userName,password);
	}
	
	@GetMapping(value = "/getMydetails")
	public Customer getMydetails() throws CustomerNotLoggedInException{
		return customerService.getMydetails();
	}
	
	@GetMapping(value = "/buyCar")
	public Transaction buyCar(@RequestBody Car car){
		return customerService.buyCar(car);
	}
	
	@GetMapping(value = "/sellCar")
	public Transaction sellCar(@RequestBody Car car){
		return customerService.sellCar(car);
	}
}