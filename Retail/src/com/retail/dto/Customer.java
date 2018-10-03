package com.retail.dto;

import java.util.Date;

public class Customer {
	String customerName;
	CustomerType customerType;
	Date dateOfRegistration;
	public Customer(String customerName, CustomerType customerType, Date dateOfRegistration) {
		super();
		this.customerName = customerName;
		this.customerType = customerType;
		this.dateOfRegistration = dateOfRegistration;
	}
	public String getCustomerName() {
		return customerName;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	
}
