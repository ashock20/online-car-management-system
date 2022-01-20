package com.cg.car.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerFullName;
	private String apartmentNumber;
	private String locality;
	private String city;
	private String state;
	private String pincode; 
	private String userName;
	private String password;
	private String emailAddress;
	private boolean canTrade;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<BankAccount> bankAccount;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Car> car;
	
	public Customer() 
	{
		
	}
	
	public Customer(int customerId, String customerFullName, String apartmentNumber, String locality, String city,
			String state, String pincode, String userName, String password, String emailAddress,
			Set<BankAccount> bankAccount, Set<Car> car, boolean canTrade) {
		super();
		this.customerId = customerId;
		this.customerFullName = customerFullName;
		this.apartmentNumber = apartmentNumber;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.bankAccount = bankAccount;
		this.canTrade = canTrade;
		this.car = car;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Set<BankAccount> getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(Set<BankAccount> bankAccount) {
		this.bankAccount = bankAccount;
	}
	public boolean isCanTrade() {
		return canTrade;
	}
	public void setCanTrade(boolean canTrade) {
		this.canTrade = canTrade;
	}
	
	public Set<Car> getCar() {
		return car;
	}
	public void setCar(Set<Car> car) {
		this.car = car;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFullName=" + customerFullName + ", apartmentNumber="
				+ apartmentNumber + ", locality=" + locality + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + ", userName=" + userName + ", password=" + password + ", emailAddress=" + emailAddress
				+ ", bankAccount=" + bankAccount + ", car=" + car + ", canTrade=" + canTrade +"]";
	}
	@Override
	public int hashCode() {
		return customerId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(apartmentNumber, other.apartmentNumber) && Objects.equals(bankAccount, other.bankAccount)
				&& Objects.equals(city, other.city) && Objects.equals(car, other.car) && Objects.equals(customerFullName, other.customerFullName)
				&& customerId == other.customerId && Objects.equals(emailAddress, other.emailAddress)
				&& Objects.equals(locality, other.locality) && Objects.equals(password, other.password)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(state, other.state)
				&& Objects.equals(userName, other.userName) && Objects.equals(canTrade, other.canTrade);
	}
	
	
}
