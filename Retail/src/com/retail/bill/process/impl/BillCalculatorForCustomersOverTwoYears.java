package com.retail.bill.process.impl;

import java.util.Map;

import com.retail.bill.process.BillCalculator;
import com.retail.dto.ItemType;
import com.retail.dto.Product;
import com.retail.factory.ProductsFactory;

/**
 * Implementation of BillCalculator - If the user has been a customer for over 2
 * years, he gets a 5% discount.
 * 
 * @author anuja.desale
 *
 */
public class BillCalculatorForCustomersOverTwoYears implements BillCalculator{
	@Override
	public double calculateNetPaybleAmount(Map<Long, Integer> listOfItems) {
		
		double totalAmount = 0;
		double netPaybleAmt = 0;
		
		for (Long itemNo : listOfItems.keySet()) {
			Product item = ProductsFactory.getProductDetails(itemNo);
			if(ItemType.GROCERY.name().equals(item.getProductType())) {
				totalAmount += (item.getPrice() * listOfItems.get(itemNo));
			} else {
				totalAmount += ((item.getPrice() * 0.95) * listOfItems.get(itemNo)); //Amount with 30% discount
			}
		}
		
		int amtForflatDiscount = (int) (totalAmount/100);
		
		netPaybleAmt = totalAmount - (amtForflatDiscount * 5);
		System.out.println("Common Customer over 2 years Calculated Net Payble Amount : " + netPaybleAmt);
		return netPaybleAmt;
	}
	
}
