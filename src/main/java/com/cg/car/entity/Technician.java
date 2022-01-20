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
public class Technician {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int technicianId;
	public String technicianName;
	public String userName;
	public String password;
	public String technicianEmailaddress;
	private String apartmentNumber;
	private String locality;
	private String city;
	private String state;
	private String pincode;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<EvaluationReport> report;
	
	public Technician()
	{}

	public Technician(int technicianId, String technicianName, String userName, String password,
			String technicianEmailaddress, String apartmentNumber, String locality, String city, String state,
			String pincode, Set<EvaluationReport> report) {
		super();
		this.technicianId = technicianId;
		this.technicianName = technicianName;
		this.userName = userName;
		this.password = password;
		this.technicianEmailaddress = technicianEmailaddress;
		this.apartmentNumber = apartmentNumber;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.report = report;
	}
	
	public int getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}

	public String getTechnicianName() {
		return technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
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

	public String getTechnicianEmailaddress() {
		return technicianEmailaddress;
	}

	public void setTechnicianEmailaddress(String technicianEmailaddress) {
		this.technicianEmailaddress = technicianEmailaddress;
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

	public Set<EvaluationReport> getReport() {
		return report;
	}

	public void setReport(Set<EvaluationReport> report) {
		this.report = report;
	}

	@Override
	public int hashCode() {
		return technicianId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Technician other = (Technician) obj;
		return Objects.equals(apartmentNumber, other.apartmentNumber) && Objects.equals(city, other.city)
				&& Objects.equals(locality, other.locality) && Objects.equals(password, other.password)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(report, other.report)
				&& Objects.equals(state, other.state)
				&& Objects.equals(technicianEmailaddress, other.technicianEmailaddress)
				&& technicianId == other.technicianId && Objects.equals(technicianName, other.technicianName)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "Technician [technicianId=" + technicianId + ", technicianName=" + technicianName + ", userName="
				+ userName + ", password=" + password + ", technicianEmailaddress=" + technicianEmailaddress
				+ ", apartmentNumber=" + apartmentNumber + ", locality=" + locality + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", report=" + report + "]";
	}
}
