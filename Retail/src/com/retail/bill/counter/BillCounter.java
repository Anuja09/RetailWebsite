package com.retail.bill.counter;

import com.retail.bill.process.BillCalculator;
import com.retail.dto.Transaction;
import com.retail.factory.DiscountCalculatorFactory;

public class BillCounter {

	public static double getNetPayableAmount(Transaction transaction) {
		BillCalculator discountCalculator = DiscountCalculatorFactory.getFactory().getCalculator(transaction.getCustomerDetails().getCustomerType());
		return discountCalculator.calculateNetPaybleAmount(transaction.getListOfItemsBought());
	
	}
}
