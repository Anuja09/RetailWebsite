package com.retail.bill;

import java.util.Map;

import com.retail.dto.Transaction;

public interface BillCalculator {
	public double calculateNetPaybleAmount(Map<Long, Integer> listOfItems);
}
