package com.retail.factory;

import com.retail.bill.process.BillCalculator;
import com.retail.bill.process.impl.BillCalculatorForAffiliates;
import com.retail.bill.process.impl.BillCalculatorForCommon;
import com.retail.bill.process.impl.BillCalculatorForCustomersOverTwoYears;
import com.retail.bill.process.impl.BillCalculatorForEmployees;
import com.retail.dto.CustomerType;

public class DiscountCalculatorFactory {
	private static DiscountCalculatorFactory discountFactory;
	public static DiscountCalculatorFactory getFactory() {
		if(discountFactory == null) {
			discountFactory = new DiscountCalculatorFactory();
		}
		return discountFactory;
	}
	
	public BillCalculator getCalculator(CustomerType customerType) {
		BillCalculator discount=null;
		if(customerType.name() != null) {
			if(CustomerType.EMPLOYEE.equals(customerType)) {
				return new BillCalculatorForEmployees();
			} else if (CustomerType.AFFILIATED.equals(customerType)) {
				return new BillCalculatorForAffiliates();
			} else if (CustomerType.CUSTOMEROVERTWOYEARS.equals(customerType)){
				return new BillCalculatorForCustomersOverTwoYears();
			} else {
				return new BillCalculatorForCommon();
			}
		}
		return discount;
	}
}
