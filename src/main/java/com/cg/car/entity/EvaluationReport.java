package com.cg.car.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EvaluationReport {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int reportId;
	
	private String carModelName;
	private String carType;
	private String carColour;
	private String carEngineNumber;
	private String carRegistrationNumber;
	private float carMileage;
	private int carYearOfManufacture;
	private String carBodyCondition;
	private String carTyreCondition;
	
	@ManyToOne
	private Car car;
	
	@ManyToOne
	private Technician technician;
	
	public EvaluationReport() {
		super();
	}

	public EvaluationReport(int reportId, String carModelName, String carType, String carColour, String carEngineNumber,
			String carRegistrationNumber, float carMileage, int carYearOfManufacture, String carBodyCondition,
			String carTyreCondition, Car car, Technician technician) {
		super();
		this.reportId = reportId;
		this.carModelName = carModelName;
		this.carType = carType;
		this.carColour = carColour;
		this.carEngineNumber = carEngineNumber;
		this.carRegistrationNumber = carRegistrationNumber;
		this.carMileage = carMileage;
		this.carYearOfManufacture = carYearOfManufacture;
		this.carBodyCondition = carBodyCondition;
		this.carTyreCondition = carTyreCondition;
		this.car = car;
		this.technician = technician;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	public String getCarEngineNumber() {
		return carEngineNumber;
	}

	public void setCarEngineNumber(String carEngineNumber) {
		this.carEngineNumber = carEngineNumber;
	}

	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

	public float getCarMileage() {
		return carMileage;
	}

	public void setCarMileage(float carMileage) {
		this.carMileage = carMileage;
	}

	public int getCarYearOfManufacture() {
		return carYearOfManufacture;
	}

	public void setCarYearOfManufacture(int carYearOfManufacture) {
		this.carYearOfManufacture = carYearOfManufacture;
	}

	public String getCarBodyCondition() {
		return carBodyCondition;
	}

	public void setCarBodyCondition(String carBodyCondition) {
		this.carBodyCondition = carBodyCondition;
	}

	public String getCarTyreCondition() {
		return carTyreCondition;
	}

	public void setCarTyreCondition(String carTyreCondition) {
		this.carTyreCondition = carTyreCondition;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	@Override
	public int hashCode() {
		return reportId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluationReport other = (EvaluationReport) obj;
		return Objects.equals(car, other.car) && Objects.equals(carBodyCondition, other.carBodyCondition)
				&& Objects.equals(carColour, other.carColour) && Objects.equals(carEngineNumber, other.carEngineNumber)
				&& Float.floatToIntBits(carMileage) == Float.floatToIntBits(other.carMileage)
				&& Objects.equals(carModelName, other.carModelName)
				&& Objects.equals(carRegistrationNumber, other.carRegistrationNumber)
				&& Objects.equals(carType, other.carType) && Objects.equals(carTyreCondition, other.carTyreCondition)
				&& carYearOfManufacture == other.carYearOfManufacture && reportId == other.reportId
				&& Objects.equals(technician, other.technician);
	}

	@Override
	public String toString() {
		return "EvaluationReport [reportId=" + reportId + ", carModelName=" + carModelName + ", carType=" + carType
				+ ", carColour=" + carColour + ", carEngineNumber=" + carEngineNumber + ", carRegistrationNumber="
				+ carRegistrationNumber + ", carMileage=" + carMileage + ", carYearOfManufacture="
				+ carYearOfManufacture + ", carBodyCondition=" + carBodyCondition + ", carTyreCondition="
				+ carTyreCondition + ", car=" + car + ", technician=" + technician + "]";
	}
	
	
	

}
