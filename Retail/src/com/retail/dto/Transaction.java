package com.retail.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Transaction {
	String storeName;
	String storeAddress;
	Customer customerDetails;
	String billNo;
	Map<Long, Integer> listOfItemsBought = new HashMap<>();
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public Customer getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public Map<Long, Integer> getListOfItemsBought() {
		return listOfItemsBought;
	}
	public void setListOfItemsBought(Map<Long, Integer> listOfItemsBought) {
		this.listOfItemsBought = listOfItemsBought;
	}
}
