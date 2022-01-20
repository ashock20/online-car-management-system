package com.cg.car.service;

import com.cg.car.entity.Admin;
import com.cg.car.entity.Car;
import com.cg.car.entity.Customer;
import com.cg.car.exception.AdminNotFoundException;
import com.cg.car.exception.CustomerNotFoundException;

public interface SystemService {
	public Admin registerAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException;
	public Admin adminLogin(String userName, String password);
	public Customer getCustomer(int custId) throws CustomerNotFoundException,AdminNotFoundException;
	
	public Car addCar(Car car);
}
