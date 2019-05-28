package com.senebii.core.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.core.cart.LineItem;
import com.senebii.core.cart.ShoppingCart;
import com.senebii.core.customer.Customer;
import com.senebii.core.product.Product;
import com.senebii.core.product.ProductType;

class EmployeeDiscountTest {
	private DiscountStrategy discountStrategy = new EmployeeDiscount();
	
	@Test
	@DisplayName("Validate discount for 1 product")
	public void testAffiliateDiscount_nonGrocery_1Product() {
		ShoppingCart order = new ShoppingCart( new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(30, discount);
	}
	
	
	@Test
	@DisplayName("Validate discount for multiple products")
	public void testAffiliateDiscount_nonGrocery_multipleProductsProduct() {
		ShoppingCart order = new ShoppingCart( new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		order.addOrUpdateItem(new LineItem(2, order, product2));
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(60, discount);
	}

}
