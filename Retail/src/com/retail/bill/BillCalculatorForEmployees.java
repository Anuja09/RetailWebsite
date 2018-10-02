package com.retail.bill;

import java.util.Map;

import com.retail.dto.ItemType;
import com.retail.dto.Product;
import com.retail.dto.ProductsFactory;

public class BillCalculatorForEmployees implements BillCalculator{

	@Override
	public double calculateNetPaybleAmount(Map<Long, Integer> listOfItems) {
		
		double totalAmount = 0;
		double netPaybleAmt = 0;
		
		for (Long itemNo : listOfItems.keySet()) {
			Product item = ProductsFactory.getProductDetails(itemNo);
			if(ItemType.GROCERY.name().equals(item.getProductType())) {
				totalAmount += (item.getPrice() * listOfItems.get(itemNo));
			} else {
				totalAmount += ((item.getPrice() * 0.7) * listOfItems.get(itemNo)); //Amount with 30% discount
			}
		}

		int amtForflatDiscount = (int) (totalAmount/100);
		netPaybleAmt = totalAmount - (amtForflatDiscount * 5);
		return netPaybleAmt;
	}
	
}
