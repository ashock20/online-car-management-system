package com.cg.car.entity;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int adminId;
	public String adminName;
	public String userName;
	public String password;
	public String adminEmailaddress;
	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Admin(int adminId, String adminName, String userName, String password, String adminEmailaddress) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.userName = userName;
		this.password = password;
		this.adminEmailaddress = adminEmailaddress;
	}



	public String getAdminName() {
		return adminName;
	}



	public void setAdminName(String adminName) {
		this.adminName = adminName;
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



	public String getAdminEmailaddress() {
		return adminEmailaddress;
	}



	public void setAdminEmailaddress(String adminEmailaddress) {
		this.adminEmailaddress = adminEmailaddress;
	}

	@Override
	public int hashCode() {
		return adminId;
				}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminEmailaddress, other.adminEmailaddress) && adminId == other.adminId
				&& Objects.equals(adminName, other.adminName) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", userName=" + userName
				+ ", password=" + password + ", adminEmailaddress=" + adminEmailaddress + "]";
	}
	
}