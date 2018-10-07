package com.retail.bill.process;

import java.util.Map;

import com.retail.dto.Transaction;

/**
 * The interface provides a template which needs to be implemented to calculate net payable amount based on discounts if any
 * 
 * @author anuja.desale
 *
 */
public interface BillCalculator {
	/**
	 * This method calculates net payable amount of the products purchased by
	 * customer
	 * 
	 * @param listOfItems
	 * @return net payable amount
	 */
	public double calculateNetPaybleAmount(Map<Long, Integer> listOfItems);
}
