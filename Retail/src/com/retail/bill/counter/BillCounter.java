package com.retail.bill.counter;

import java.util.Date;

import com.retail.bill.process.BillCalculator;
import com.retail.dto.CustomerType;
import com.retail.dto.Transaction;
import com.retail.factory.BillCalculatorFactory;

/**
 * This class represents the bill counter where customers purchase order is
 * accepted and delegated to appropriate bill calculator and then, gets net
 * payable amount and returns to counter.
 * 
 * @author anuja.desale
 *
 */
public class BillCounter {

	/**
	 * This method gets the net payable amount calculated in bill calculator
	 * 
	 * @param transaction
	 * @return net payable amount
	 */
	public static double getNetPayableAmount(Transaction transaction) {

		CustomerType customerType = transaction.getCustomerDetails().getCustomerType();

		if (CustomerType.COMMON.equals(customerType) && (BillCounter
				.isRegistrationDateOverTwoYears(transaction.getCustomerDetails().getDateOfRegistration()))) {
			customerType = CustomerType.CUSTOMEROVERTWOYEARS;
		}

		BillCalculator discountCalculator = BillCalculatorFactory.getFactory().getCalculator(customerType);
		return discountCalculator.calculateNetPaybleAmount(transaction.getListOfItemsBought());

	}

	/**
	 * isRegistrationDateOverTwoYears - This method checks if user is registered to
	 * store before 2 years
	 * 
	 * @param dateOfRegistration
	 * @return date difference in years
	 */
	private static boolean isRegistrationDateOverTwoYears(Date dateOfRegistration) {
		Date currentDate = new Date();

		long diff = currentDate.getTime() - dateOfRegistration.getTime();
		double years = (((diff / 1000) / (3600)) / 24) / 365;

		if (years > 2) {
			return true;
		}

		return false;
	}

}
