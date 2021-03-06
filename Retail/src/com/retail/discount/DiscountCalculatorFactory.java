package com.retail.discount;

import com.retail.bill.BillCalculator;
import com.retail.bill.BillCalculatorForAffiliates;
import com.retail.bill.BillCalculatorForCommon;
import com.retail.bill.BillCalculatorForCustomersOverTwoYears;
import com.retail.bill.BillCalculatorForEmployees;
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
