package com.cg.car.service;

import java.util.List;

import com.cg.car.entity.EvaluationReport;
import com.cg.car.entity.Technician;
import com.cg.car.exception.CarNotFoundException;
import com.cg.car.exception.EvaluationReportNotFoundException;

public interface TechnicianService {

	public EvaluationReport generateReport(EvaluationReport report, int carId) throws CarNotFoundException;
	public EvaluationReport updateReport(EvaluationReport report);
	public EvaluationReport deleteReport(int reportID) throws EvaluationReportNotFoundException;
	public EvaluationReport showReport(int reportID) throws EvaluationReportNotFoundException;
	public List<EvaluationReport> getReports();
	public Technician techLogin(String userName, String password);
	public Technician getLoggedInTechniciandetails();
	public EvaluationReport evaluateCustomerCar(EvaluationReport report, int carId, int customerId) throws CarNotFoundException;
}
