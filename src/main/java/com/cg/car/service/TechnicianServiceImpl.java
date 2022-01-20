package com.cg.car.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.car.dao.CarRepository;
import com.cg.car.dao.CustomerRepository;
import com.cg.car.dao.TechnicianLoginRepository;
import com.cg.car.dao.TechnicianRepository;
import com.cg.car.entity.Car;
import com.cg.car.entity.Customer;
import com.cg.car.entity.EvaluationReport;
import com.cg.car.entity.Technician;
import com.cg.car.exception.CarNotFoundException;
import com.cg.car.exception.CustomerNotFoundException;
import com.cg.car.exception.EvaluationReportNotFoundException;
import com.cg.car.exception.TechnicianNotFoundException;

@Service
public class TechnicianServiceImpl implements TechnicianService {
	private static int loggedInTechnicianId = 0;
	@Autowired
	private TechnicianRepository techRepo;
	
	@Autowired
	private TechnicianLoginRepository techLoginRepo;
	
	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public EvaluationReport generateReport(EvaluationReport report, int carId) throws CarNotFoundException
	{
		report.setTechnician(getLoggedInTechniciandetails());
		Optional<Car> carTobeEvaluated = carRepo.findById(carId);
		if(carTobeEvaluated.isPresent())
		{
			Car car = carTobeEvaluated.get();
			Set<EvaluationReport> reports = car.getReport();
			reports.add(report);
			car.setReport(reports);
			carRepo.save(car);
			return techRepo.save(report);
		}
		else
		{
			throw new CarNotFoundException("Check Car ID");
		}
	}

	@Override
	public EvaluationReport updateReport(EvaluationReport report) {
		return techRepo.save(report);
	}

	@Override
	public EvaluationReport deleteReport(int reportId) {
		Optional<EvaluationReport> existingReport = techRepo.findById(reportId);
		
		EvaluationReport report = null;
		if(existingReport.isPresent()) 
		{
			techRepo.deleteById(reportId);
			report = existingReport.get();
		}
		else 
		{
			throw new EvaluationReportNotFoundException("No such Report Found");
		}
		return report;
	}

	@Override
	public EvaluationReport showReport(int reportId) {
		Optional<EvaluationReport> existingReport = techRepo.findById(reportId);
		
		EvaluationReport report = null;
		if(existingReport.isPresent()) {
			report = existingReport.get();
		}else {
			throw new EvaluationReportNotFoundException("No such Report Found");
		}
		return report;
	}

	@Override
	public List<EvaluationReport> getReports() {
		return techRepo.findAll();
	}
	
	@Override
	public Technician techLogin(String userName, String password)
	{
		Technician loggedInTechnician = techLoginRepo.findByuserNameAndPassword(userName, password);
		loggedInTechnicianId = loggedInTechnician.getTechnicianId();
		return loggedInTechnician;
	}

	@Override
	public Technician getLoggedInTechniciandetails() {
		// TODO Auto-generated method stub
		Optional<Technician> existingTechnician = techLoginRepo.findById(loggedInTechnicianId);
		Technician technician = null;
		if(existingTechnician.isPresent()) 
		{
			technician = existingTechnician.get();
		}
		else 
		{
			throw new TechnicianNotFoundException("You have to Login first!!");
		}
		return technician;
	}

	@Override
	public EvaluationReport evaluateCustomerCar(EvaluationReport report, int carId, int customerId) 
			throws CarNotFoundException,CustomerNotFoundException
	{
		Optional<Customer> customer = custRepo.findById(customerId);
		if(customer.isPresent())
		{
			Optional<Car> carToEvaluate = carRepo.findById(carId);
			if(carToEvaluate.isPresent())
			{
				Customer carOwner = customer.get();
				Car car = carToEvaluate.get();
				Set<EvaluationReport> carReports = car.getReport();
				carReports.add(report);
				car.setReport(carReports);
				Set<Car> cars = carOwner.getCar();
				cars.add(car);
				carOwner.setCar(cars);
				
				custRepo.save(carOwner);
				return techRepo.save(report);
			}
			else
			{
				throw new CarNotFoundException("Customer doesn't own this Car!! Check ID");
			}
		}
		else
		{
			throw new CustomerNotFoundException("No Customer Found!!.. Check ID");
		}
	}
}
