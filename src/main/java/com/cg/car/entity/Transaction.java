package com.cg.car.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private double finalAmount;
	private String paymentMethod;
	private LocalDateTime transactionDateTime;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Car car;
	
	public Transaction() {
		super();
	}

	
	public Transaction(double finalAmount, String paymentMethod, LocalDateTime transactionDateTime, Customer customer, Car car) {
		super();
		this.finalAmount = finalAmount;
		this.paymentMethod = paymentMethod;
		this.transactionDateTime = transactionDateTime;
		this.customer = customer;
		this.car = car;
	}

	
	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	@Override
	public int hashCode() {
		return transactionId;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(car, other.car)
				&& Double.doubleToLongBits(finalAmount) == Double.doubleToLongBits(other.finalAmount)
				&& Objects.equals(paymentMethod, other.paymentMethod)
				&& Objects.equals(transactionDateTime, other.transactionDateTime)
				&& transactionId == other.transactionId;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", finalAmount=" + finalAmount + ", paymentMethod="
				+ paymentMethod + ", transactionDateTime=" + transactionDateTime + ", customer=" + customer + ", car=" + car +"]";
	}

}
