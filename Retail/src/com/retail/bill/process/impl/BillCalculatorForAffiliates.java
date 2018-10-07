package com.retail.bill.process.impl;

import java.util.Map;

import com.retail.bill.process.BillCalculator;
import com.retail.dto.ItemType;
import com.retail.dto.Product;
import com.retail.factory.ProductsFactory;

/**
 * Implementation of BillCalculator - If the user is an affiliate of the store, he
 * gets a 10% discount
 * 
 * @author anuja.desale
 *
 */
public class BillCalculatorForAffiliates implements BillCalculator{

	@Override
	public double calculateNetPaybleAmount(Map<Long, Integer> listOfItems) {
		
		double totalAmount = 0;
		double netPaybleAmt = 0;
		
		for (Long itemNo : listOfItems.keySet()) {
			Product item = ProductsFactory.getProductDetails(itemNo);
			if(ItemType.GROCERY.name().equals(item.getProductType())) {
				totalAmount += (item.getPrice() * listOfItems.get(itemNo));
			} else {
				totalAmount += ((item.getPrice() * 0.9) * listOfItems.get(itemNo)); //Amount with 30% discount
			}
		}
		int amtForflatDiscount = (int) (totalAmount/100);
		netPaybleAmt = totalAmount - (amtForflatDiscount * 5);
		System.out.println("Affiliate Calculated Net Payble Amount : " + netPaybleAmt);
		return netPaybleAmt;
	}
	
}
