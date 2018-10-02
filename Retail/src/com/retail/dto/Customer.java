package com.retail.dto;

public class Customer {
	String customerName;
	CustomerType customerType;
	String customerMobileNo;
	public Customer(String customerName, CustomerType customerType) {
		super();
		this.customerName = customerName;
		this.customerType = customerType;
		this.customerMobileNo = "1234567891";
	}
	public String getCustomerName() {
		return customerName;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public String getCustomerMobileNo() {
		return customerMobileNo;
	}
	
	
}
