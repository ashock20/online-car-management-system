package com.cg.car.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.car.dao.CarRepository;
import com.cg.car.dao.CustomerRepository;
import com.cg.car.entity.Car;
import com.cg.car.entity.Customer;
import com.cg.car.entity.Transaction;
import com.cg.car.exception.CustomerNotFoundException;
import com.cg.car.exception.CustomerNotLoggedInException;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static int loggedUserId = 0;
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired 
	private CarRepository carRepo;
	
	@Override
	public Customer registerCustomer(Customer Customer) {
		return custRepo.save(Customer);
	}

	@Override
	public Customer updateCustomer(Customer Customer) {
		return custRepo.save(Customer);
	}

	@Override
	public Customer deleteCustomer(int custId)  throws CustomerNotFoundException{
		Optional<Customer> Customer = custRepo.findById(custId);

		Customer customer = null;
		if(Customer.isPresent()) {
			custRepo.deleteById(custId);
			customer = Customer.get();
		}else {
			throw new CustomerNotFoundException("No such Customer");
		}
		return customer;
	}


	


	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) custRepo.findAll();
	}

	@Override
	public Customer login(String userName,String password) {
		// TODO Auto-generated method stub
		Customer loggedInUser = custRepo.findByuserNameAndPassword(userName,password);
		loggedUserId = loggedInUser.getCustomerId();
		return loggedInUser;
	}

	@Override
	public Customer getMydetails() throws CustomerNotLoggedInException{
		// TODO Auto-generated method stub
		Optional<Customer> existingCustomer = custRepo.findById(loggedUserId);
		Customer customer = null;
		if(existingCustomer.isPresent()) 
		{
			customer = existingCustomer.get();
		}
		else 
		{
			throw new CustomerNotLoggedInException("You have to Login first!!");
		}
		return customer;
	}

	@Override
	public Transaction buyCar(Car car) {
		// TODO Auto-generated method stub
		LocalDateTime transactionDateAndTime = LocalDateTime.now();
		Transaction transaction = new Transaction();

		Customer customer = getMydetails();
		Set<Car> cars = customer.getCar();
		cars.add(car);
		customer.setCar(cars);
		updateCustomer(customer);
		transaction.setFinalAmount(car.getQuotedPrice());
		transaction.setPaymentMethod(getMydetails().getBankAccount().toString());
		transaction.setTransactionDateTime(transactionDateAndTime);
		transaction.setCar(car);
		
		
		return transaction;
	}

	@Override
	public Transaction sellCar(Car car) {
		// TODO Auto-generated method stub
		LocalDateTime transactionDateAndTime = LocalDateTime.now();
		Transaction transaction = new Transaction();
		Customer owner = getMydetails();
		Set<Car> ownerCars = owner.getCar();
		ownerCars.remove(car);
		owner.setCar(ownerCars);
		updateCustomer(owner);
		transaction.setFinalAmount(car.getQuotedPrice());
		transaction.setPaymentMethod(getMydetails().getBankAccount().toString());
		transaction.setTransactionDateTime(transactionDateAndTime);
		transaction.setCar(car);
		
		carRepo.save(car);
		return transaction;
	}
}