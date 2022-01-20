package com.cg.car.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.car.dao.AdminSystemRepository;
import com.cg.car.dao.CarRepository;
import com.cg.car.dao.CustomerRepository;
import com.cg.car.entity.Admin;
import com.cg.car.entity.Car;
import com.cg.car.entity.Customer;
import com.cg.car.exception.AdminNotFoundException;
import com.cg.car.exception.CustomerNotFoundException;
@Service
public class SystemServiceImpl implements SystemService{
	private static boolean adminLoggedIn = false;
	@Autowired
	private AdminSystemRepository sysRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private CarRepository carRepo;
	
	@Override
	public Admin registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return sysRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return sysRepo.save(admin);
	}

	@Override
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException{
		// TODO Auto-generated method stub
		Optional<Admin> existingAdmin = sysRepo.findById(adminId);
		
		Admin admin = null;
		if(existingAdmin.isPresent()) {
			admin = existingAdmin.get();
			sysRepo.deleteById(adminId);
		}else {
			throw new AdminNotFoundException("No such Admin!! Check Id");
		}
		return admin;
	}

	@Override
	public Admin adminLogin(String userName, String password){
		// TODO Auto-generated method stub
		Optional<Admin> existingAdmin = sysRepo.findByuserNameAndPassword(userName, password);
		Admin admin = null;
		if(existingAdmin.isPresent())
		{
			adminLoggedIn = true;
			admin = existingAdmin.get();
		}
 		return admin;
	}
	
	@Override 
	public Customer getCustomer(int custId) throws CustomerNotFoundException,AdminNotFoundException
	{ 
		if(adminLoggedIn) 
		{
			Optional<Customer> existingCustomer = custRepo.findById(custId); Customer customer = null;
			if(existingCustomer.isPresent()) 
			{ 
				customer = existingCustomer.get(); 
			}
			else 
			{
				throw new CustomerNotFoundException("No such Customer"); 
			} 
			return customer; 
		}
		else
		{
			throw new AdminNotFoundException("Admin not Logged in!! Please Log in First.");
		}
	}

	@Override
	public Car addCar(Car car) {
		// TODO Auto-generated method stub
		return carRepo.save(car);
	}
}
