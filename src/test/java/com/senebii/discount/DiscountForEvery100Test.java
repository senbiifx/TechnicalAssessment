package com.senebii.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.order.Order;
import com.senebii.order.OrderProduct;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

public class DiscountForEvery100Test {
	private static DiscountStrategy discountStrategy = new DiscountForEvery100();
	
	@Test
	@DisplayName("Validate discount for 1 product with price greater than 100")
	public void testDiscountForEvery100_above100() {
		Order order = new Order(1);
		Product product = new Product(1, 120, ProductType.GROCERY);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		double discount = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(5, discount);
	}
	
	@Test
	@DisplayName("Validate discount for 1 product of multiple quantities with price greater than 100")
	public void testDiscountForEvery100_above100_multipleProductsOfMultipleQuantites() {
		Order order = new Order(1);
		Product product = new Product(1, 50, ProductType.GROCERY);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product, 2));
		double discount = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(5, discount);
	}
	
	@Test
	@DisplayName("Validate discount for multiple products with price greater than 100")
	public void testDiscountForEvery100_above100_multipleProducts() {
		Product chicken = new Product(1, 120, ProductType.GROCERY);
		Product beef = new Product(1, 180, ProductType.GROCERY);
		Order order = new Order(1);
		List<OrderProduct> orderProducts = Arrays.asList( new OrderProduct(1, order, chicken),
														new OrderProduct(1, order, beef) );
		double discount = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(15, discount);
	}
	
	@Test
	@DisplayName("Validate discount for 1 product with price less than 100")
	public void testDiscountForEvery100_below100() {
		Order order = new Order(1);
		Product product = new Product(1, 80, ProductType.GROCERY);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		double discount = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(0, discount);
	}
	
	@Test
	@DisplayName("Validate discount for multiple products with total price less than 100")
	public void testDiscountForEvery100_below100_multipleProducts() {
		Order order = new Order(1);
		Product chicken = new Product(1, 30, ProductType.GROCERY);
		Product beef = new Product(1, 30, ProductType.GROCERY);
		List<OrderProduct> orderProducts = Arrays.asList( new OrderProduct(1, order, chicken),
														new OrderProduct(1, order, beef) );
		double discount = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(0, discount);
	}
	
	
	@Test
	@DisplayName("Validate discount for 1 product with total price equal to 100")
	public void testDiscountForEvery100_equals100() {
		Order order = new Order(1);
		Product chicken = new Product(1, 100, ProductType.GROCERY);
		List<OrderProduct> orderProducts = Arrays.asList( new OrderProduct(1, order, chicken) );
		double discount = discountStrategy.calculateDiscount(orderProducts);
		assertEquals(5, discount);
	}
}
