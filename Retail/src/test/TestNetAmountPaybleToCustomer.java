package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.retail.bill.counter.BillCounter;
import com.retail.dto.Customer;
import com.retail.dto.CustomerType;
import com.retail.dto.Transaction;
import com.retail.factory.ProductsFactory;

import junit.framework.TestCase;

public class TestNetAmountPaybleToCustomer extends TestCase {
	@Before
	public void setUp() {
		ProductsFactory.initialiseFactory();
	}
	
	@Test
	public void testGenerateBillForEmployees() {
		Customer customer = new Customer("Customer1",CustomerType.EMPLOYEE, new Date());
		
		Transaction transaction = new Transaction();
		transaction.setBillNo("101");
		transaction.setCustomerDetails(customer);
		transaction.setStoreName("DMart");
		transaction.setStoreAddress("JM Road, Pune");
		Map<Long, Integer> listOfItemsBought = new HashMap<>();//map of product no and quantity
		listOfItemsBought.put(1001L, 1);
		listOfItemsBought.put(2002L, 1);
		listOfItemsBought.put(3001L, 3);
		listOfItemsBought.put(3002L, 2);
		transaction.setListOfItemsBought(listOfItemsBought);
		assertEquals(2195.0, BillCounter.getNetPayableAmount(transaction));
	}
	
	@Test
	public void testGenerateBillForAffiliates() {
		Customer customer = new Customer("Customer2",CustomerType.AFFILIATED, new Date());
		
		Transaction transaction = new Transaction();
		transaction.setBillNo("101");
		transaction.setCustomerDetails(customer);
		transaction.setStoreName("DMart");
		transaction.setStoreAddress("JM Road, Pune");
		Map<Long, Integer> listOfItemsBought = new HashMap<>();
		listOfItemsBought.put(1001L, 1);
		listOfItemsBought.put(2002L, 1);
		listOfItemsBought.put(3001L, 1);
		listOfItemsBought.put(3002L, 1);
		transaction.setListOfItemsBought(listOfItemsBought);
		
		assertEquals(1330.0, BillCounter.getNetPayableAmount(transaction));
	}
	
	@Test
	public void testGenerateBillForCustomerOverTwoYears() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date regitrationDate = null;
		try {
			 regitrationDate = sdf.parse("10-10-2014");
		} catch (ParseException e) {
			 regitrationDate = new Date();
			e.printStackTrace();
		}
		Customer customer = new Customer("Customer3",CustomerType.COMMON, regitrationDate);
		
		Transaction transaction = new Transaction();
		transaction.setBillNo("101");
		transaction.setCustomerDetails(customer);
		transaction.setStoreName("DMart");
		transaction.setStoreAddress("JM Road, Pune");
		Map<Long, Integer> listOfItemsBought = new HashMap<>();
		listOfItemsBought.put(1001L, 1);
		listOfItemsBought.put(2002L, 1);
		listOfItemsBought.put(3001L, 1);
		listOfItemsBought.put(3002L, 1);
		transaction.setListOfItemsBought(listOfItemsBought);
			
		assertEquals(1402.5, BillCounter.getNetPayableAmount(transaction));
	}
	
	@Test
	public void testGenerateBillForCommonCustomers() {
		Customer customer = new Customer("Customer4",CustomerType.COMMON, new Date());
		
		Transaction transaction = new Transaction();
		transaction.setBillNo("101");
		transaction.setCustomerDetails(customer);
		transaction.setStoreName("DMart");
		transaction.setStoreAddress("JM Road, Pune");
		Map<Long, Integer> listOfItemsBought = new HashMap<>();//map of product no and quantity
		listOfItemsBought.put(1001L, 1);
		listOfItemsBought.put(2002L, 1);
		listOfItemsBought.put(3001L, 1);
		listOfItemsBought.put(3002L, 1);
		transaction.setListOfItemsBought(listOfItemsBought);
		
		assertEquals(1475.0, BillCounter.getNetPayableAmount(transaction));
	}
	
	@After
	public void tearDown() {
		ProductsFactory.clearFactory();
	}
}
