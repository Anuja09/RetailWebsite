package com.retail.dto;

public class Product {
	long productNo;
	String productName;
	ItemType productType;
	double price;
	
	
	public Product(long productNo, String productName, ItemType productType, double price) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ItemType getProductType() {
		return productType;
	}
	public void setProductType(ItemType productType) {
		this.productType = productType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
