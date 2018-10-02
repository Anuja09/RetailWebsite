package com.retail.dto;

import java.util.Map;

import com.retail.discount.DiscountCalculatorFactory;
import com.retail.discount.customers.BillCalculator;

public class Bill {

	public static double calculate(Customer customerDetails, Map<Long, Integer> listOfItemsBought) {
		BillCalculator discountCalculator = DiscountCalculatorFactory.getFactory().getCalculator(customerDetails.getCustomerType());
		return discountCalculator.calculateNetPaybleAmount(listOfItemsBought);
	
	}
}
