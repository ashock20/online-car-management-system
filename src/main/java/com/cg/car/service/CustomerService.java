package com.cg.car.service;

import java.util.List;

import com.cg.car.entity.Car;
import com.cg.car.entity.Customer;
import com.cg.car.entity.Transaction;
import com.cg.car.exception.CustomerNotFoundException;
import com.cg.car.exception.CustomerNotLoggedInException;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException;
	public List<Customer> getAllCustomers();
	public Customer login(String userName, String password);
	public Customer getMydetails() throws CustomerNotLoggedInException;
	public Transaction buyCar(Car car);
	public Transaction sellCar(Car car);
}