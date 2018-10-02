package com.retail.bill;

import java.util.Map;

import com.retail.dto.ItemType;
import com.retail.dto.Product;
import com.retail.dto.ProductsFactory;

public class BillCalculatorForCommon implements BillCalculator{
	@Override
	public double calculateNetPaybleAmount(Map<Long, Integer> listOfItems) {
		
		double totalAmount = 0;
		double netPaybleAmt = 0;
		
		for (Long itemNo : listOfItems.keySet()) {
			Product item = ProductsFactory.getProductDetails(itemNo);
			totalAmount += (item.getPrice() * listOfItems.get(itemNo));
		}
		
		int amtForflatDiscount = (int) (totalAmount/100);
		netPaybleAmt = totalAmount - (amtForflatDiscount * 5);
		
		return netPaybleAmt;
	}
	
}
