package com.retail.factory;

import java.util.HashMap;
import java.util.Map;

import com.retail.dto.ItemType;
import com.retail.dto.Product;

/**
 * The factory class represents the factory of available products in the store
 * 
 * @author anuja.desale
 *
 */
public class ProductsFactory {
	private static Map<Long, Product> productDetailsList = new HashMap<>();
	private ProductsFactory() {
		
	}
	public static void initialiseFactory() {
		addToCatalog(new Product(1001L, "Item1", ItemType.CLOTHES, 50.00d));
		addToCatalog( new Product(1003L, "Item7", ItemType.CLOTHES, 350.00d));
		addToCatalog(new Product(1002L, "Item2", ItemType.HOMEAPPLIANCE, 100.00d));
		addToCatalog( new Product(2001L, "Item3", ItemType.CLOTHES, 500.00d));
		addToCatalog( new Product(2002L, "Item4", ItemType.GROCERY, 250.00d));
		addToCatalog(new Product(3001L, "Item5", ItemType.FOOD, 500.00d));
		addToCatalog(new Product(3002L, "Item6", ItemType.TOYS, 750.00d));
	}
	
	public static void clearFactory() {
		productDetailsList.clear();
		
	}

	public static Product getProductDetails(Long itemNo) {
		return productDetailsList.get(itemNo);
	}
	
	private static void addToCatalog(Product product) {
		productDetailsList.put(product.getProductNo(), product);
	}
}
