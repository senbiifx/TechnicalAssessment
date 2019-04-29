package com.senebii.discount;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.order.Order;
import com.senebii.order.OrderProduct;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

class BasePercentageDiscountTest {

	@Test
	@DisplayName("Validate total amount of order list, where order list contains 1 Non Grocery product")
	void testTotalAmount_1NonGrocery() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		Order order = new Order(1);
		Product product = new Product(1, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		
		double total = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(100, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains multiple Non Grocery product")
	void testTotalAmount_multipleNonGrocery() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		Order order = new Order(1);
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 300, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product), new OrderProduct(2, order, product2));
		
		double total = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(400, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains multiple Non Grocery Products of multiple quanties")
	void testTotalAmount_multipleNonGrocery_multipleQuantities() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		Order order = new Order(1);
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 300, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product, 2), new OrderProduct(2, order, product2, 2));
		
		double total = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(800, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains 1 Grocery product")
	void testTotalAmount_1Grocery() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		Order order = new Order(1);
		Product product = new Product(1, 100, ProductType.GROCERY);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		
		double total = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(0, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains multiple Grocery product")
	void testTotalAmount_multipleGrocery() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		Order order = new Order(1);
		Product product = new Product(1, 100, ProductType.GROCERY);
		Product product2 = new Product(2, 300, ProductType.GROCERY);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product), new OrderProduct(2, order, product2));
		
		double total = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(0, total);
	}
	
	@Test
	@DisplayName("Validate total amount of order list, where order list contains 1 Grocery  and 1 non-grocery")
	void testTotalAmount_Assorted() {
		BasePercentageDiscountStub discountStrategy = new BasePercentageDiscountStub();
		Order order = new Order(1);
		Product product = new Product(1, 100, ProductType.GROCERY);
		Product product2 = new Product(2, 300, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product), new OrderProduct(2, order, product2));
		
		double total = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(300, total);
	}
	
	
	
	class BasePercentageDiscountStub extends BasePercentageDiscount{

		@Override
		public double calculateNonGroceryItemsDiscount(double total) {
			return total;
		}
		
	}

}
