package com.senebii.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.cart.LineItem;
import com.senebii.cart.ShoppingCart;
import com.senebii.customer.Customer;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

class BasePercentageDiscountTest {

	@Test
	@DisplayName("Validate total amount of order list, where order list contains 1 Non Grocery product")
	void testTotalAmount_1NonGrocery() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		
		double total = discountStrategy.calculateDiscount(order);
		assertEquals(100, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains multiple Non Grocery product")
	void testTotalAmount_multipleNonGrocery() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 300, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		order.addOrUpdateItem(new LineItem(2, order, product2));
		
		double total = discountStrategy.calculateDiscount(order);
		assertEquals(400, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains multiple Non Grocery Products of multiple quanties")
	void testTotalAmount_multipleNonGrocery_multipleQuantities() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 300, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product, 2));
		order.addOrUpdateItem(new LineItem(2, order, product2, 2));
		
		double total = discountStrategy.calculateDiscount(order);
		assertEquals(800, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains 1 Grocery product")
	void testTotalAmount_1Grocery() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		ShoppingCart order = new ShoppingCart( new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.GROCERY);
		order.addOrUpdateItem(new LineItem(1, order, product));
		
		double total = discountStrategy.calculateDiscount(order);
		assertEquals(0, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains multiple Grocery product")
	void testTotalAmount_multipleGrocery() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		ShoppingCart order = new ShoppingCart( new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.GROCERY);
		Product product2 = new Product(2, 300, ProductType.GROCERY);
		order.addOrUpdateItem(new LineItem(1, order, product));
		order.addOrUpdateItem(new LineItem(2, order, product2));
		
		double total = discountStrategy.calculateDiscount(order);
		assertEquals(0, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains 1 Grocery  and 1 non-grocery")
	void testTotalAmount_Assorted() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		ShoppingCart order = new ShoppingCart( new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.GROCERY);
		Product product2 = new Product(2, 300, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		order.addOrUpdateItem(new LineItem(2, order, product2));
		double total = discountStrategy.calculateDiscount(order);
		assertEquals(300, total);
	}
	
	
	
	class BasePercentageDiscountStub extends BasePercentageDiscount{

		@Override
		public double calculateNonGroceryItemsDiscount(double total) {
			return total;
		}
		
	}

}
