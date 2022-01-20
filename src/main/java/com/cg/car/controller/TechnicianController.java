package com.cg.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.car.entity.EvaluationReport;
import com.cg.car.entity.Technician;
import com.cg.car.exception.EvaluationReportNotFoundException;
import com.cg.car.service.TechnicianService;


@RestController
public class TechnicianController {
	
	@Autowired
	private TechnicianService technicianService;
	
	@PostMapping(value = "/generateReport/carId")
	public EvaluationReport generateReport(@RequestBody EvaluationReport report,@PathVariable int carId) {
		return technicianService.generateReport(report,carId);
	}
	
	@PutMapping(value = "/updateReport")
	public EvaluationReport updateReport(@RequestBody EvaluationReport report) {
		return technicianService.updateReport(report);
	}
	
//	@DeleteMapping(value = "/delete/{id}")
//	public Report deleteReport(@PathVariable("id") int reportID) throws ReportNotFoundException{
//		return technicianService.deleteReport(reportID);
//	}
	
	@GetMapping(value = "/getReport/{id}")
	public EvaluationReport showReport(@PathVariable("id") int reportID) throws EvaluationReportNotFoundException{
		return technicianService.showReport(reportID);
	}
	
	@GetMapping(value = "/getAllReports")
	public List<EvaluationReport> getReports() {
		return technicianService.getReports();
	}
	
	@GetMapping(value="/technician/login/{userName}/{password}")
	public Technician loginTechnician(@PathVariable String userName,@PathVariable String password)
	{
		return technicianService.techLogin(userName, password);
	}
	
	@PutMapping(value="/technician/evaluateCustomerCar/{carId}/{custId}")
	public EvaluationReport evaluateCustomerCar
		(@RequestBody EvaluationReport report, @PathVariable int carId, @PathVariable int custId)
	{
		return technicianService.evaluateCustomerCar(report, carId, custId);
	}
}
