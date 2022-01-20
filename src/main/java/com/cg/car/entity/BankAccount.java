package com.cg.car.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private long accountNumber;
	private String accountType;
	private String bankName;
	private String ifscCode;
	private String bankAddress;
	private String branchName;
	
	@ManyToOne
	private Customer customer;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public BankAccount()
	{
		
	}
	public BankAccount(int accountId, long accountNumber, String accountType, String bankName, String ifscCode,
			String bankAddress, String branchName) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.bankAddress = bankAddress;
		this.branchName = branchName;
	}
	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", bankName=" + bankName + ", ifscCode=" + ifscCode + ", bankAddress=" + bankAddress
				+ ", branchName=" + branchName + "]";
	}
	@Override
	public int hashCode() {
		return accountId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return accountId == other.accountId && accountNumber == other.accountNumber
				&& Objects.equals(accountType, other.accountType) && Objects.equals(bankAddress, other.bankAddress)
				&& Objects.equals(bankName, other.bankName) && Objects.equals(branchName, other.branchName)
				&& Objects.equals(ifscCode, other.ifscCode);
	}
	
	
}
