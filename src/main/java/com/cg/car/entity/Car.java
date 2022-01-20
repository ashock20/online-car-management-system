package com.cg.car.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	private String carNumber;
	private String modelName;
	private double totalKilometers;
	private int yearOfManufacturing;
	private int noOfSeats;
	private double quotedPrice;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<EvaluationReport> report;
	
	public Car() {
		
	}

	
	public Car(int carId, String carNumber, String modelName, double totalKilometers, int yearOfManufacturing,
			int noOfSeats, double quotedPrice, Customer customer, Set<EvaluationReport> report) {
		super();
		this.carId = carId;
		this.carNumber = carNumber;
		this.modelName = modelName;
		this.totalKilometers = totalKilometers;
		this.yearOfManufacturing = yearOfManufacturing;
		this.noOfSeats = noOfSeats;
		this.quotedPrice = quotedPrice;
		this.customer = customer;
		this.report = report;
	}


	public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}


	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getTotalKilometers() {
		return totalKilometers;
	}

	public void setTotalKilometers(double totalKilometers) {
		this.totalKilometers = totalKilometers;
	}

	public int getYearOfManufacturing() {
		return yearOfManufacturing;
	}

	public void setYearOfManufacturing(int yearOfManufacturing) {
		this.yearOfManufacturing = yearOfManufacturing;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public double getQuotedPrice() {
		return quotedPrice;
	}

	public void setQuotedPrice(double quotedPrice) {
		this.quotedPrice = quotedPrice;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Set<EvaluationReport> getReport() {
		return report;
	}
	
	public void setReport(Set<EvaluationReport> report) {
		this.report = report;
	}


	@Override
	public int hashCode() {
		return carId;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return carId == other.carId && Objects.equals(carNumber, other.carNumber)
				&& Objects.equals(customer, other.customer) && Objects.equals(modelName, other.modelName)
				&& noOfSeats == other.noOfSeats
				&& Double.doubleToLongBits(quotedPrice) == Double.doubleToLongBits(other.quotedPrice)
				&& Double.doubleToLongBits(totalKilometers) == Double.doubleToLongBits(other.totalKilometers)
				&& yearOfManufacturing == other.yearOfManufacturing;
	}


	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carNumber=" + carNumber + ", modelName=" + modelName + ", totalKilometers="
				+ totalKilometers + ", yearOfManufacturing=" + yearOfManufacturing + ", noOfSeats=" + noOfSeats
				+ ", quotedPrice=" + quotedPrice + ", customer=" + customer + ", report=" + report + "]";
	}

}
