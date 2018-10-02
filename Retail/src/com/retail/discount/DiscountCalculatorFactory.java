package com.retail.discount;

import com.retail.discount.customers.BillCalculatorForEmployees;
import com.retail.discount.customers.BillCalculator;
import com.retail.discount.customers.BillCalculatorForAffiliates;
import com.retail.discount.customers.BillCalculatorForCommon;
import com.retail.discount.customers.BillCalculatorForCustomersOverTwoYears;
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
