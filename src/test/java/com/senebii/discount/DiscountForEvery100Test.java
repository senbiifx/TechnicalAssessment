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

public class DiscountForEvery100Test {
	private static DiscountStrategy discountStrategy = new DiscountForEvery100();
	
	@Test
	@DisplayName("Validate discount for 1 product with price greater than 100")
	public void testDiscountForEvery100_above100() {
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product product = new Product(1, 120, ProductType.GROCERY);
		order.addOrUpdateItem(new LineItem(1, order, product));
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(5, discount);
	}
	
	@Test
	@DisplayName("Validate discount for 1 product of multiple quantities with price greater than 100")
	public void testDiscountForEvery100_above100_multipleProductsOfMultipleQuantites() {
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product product = new Product(1, 50, ProductType.GROCERY);
		order.addOrUpdateItem(new LineItem(1, order, product, 2));
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(5, discount);
	}
	
	@Test
	@DisplayName("Validate discount for multiple products with price greater than 100")
	public void testDiscountForEvery100_above100_multipleProducts() {
		Product chicken = new Product(1, 120, ProductType.GROCERY);
		Product beef = new Product(2, 180, ProductType.GROCERY);
		ShoppingCart order = new ShoppingCart( new Customer(1, new Date()));
		order.addOrUpdateItem(new LineItem(1, order, chicken));
		order.addOrUpdateItem(new LineItem(2, order, beef) );
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(15, discount);
	}
	
	@Test
	@DisplayName("Validate discount for 1 product with price less than 100")
	public void testDiscountForEvery100_below100() {
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product product = new Product(1, 80, ProductType.GROCERY);
		order.addOrUpdateItem(new LineItem(1, order, product));
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(0, discount);
	}
	
	@Test
	@DisplayName("Validate discount for multiple products with total price less than 100")
	public void testDiscountForEvery100_below100_multipleProducts() {
		ShoppingCart order = new ShoppingCart( new Customer(1, new Date()));
		Product chicken = new Product(1, 30, ProductType.GROCERY);
		Product beef = new Product(1, 30, ProductType.GROCERY);
		order.addOrUpdateItem(new LineItem(1, order, chicken));
		order.addOrUpdateItem(new LineItem(2, order, beef) );
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(0, discount);
	}
	
	
	@Test
	@DisplayName("Validate discount for 1 product with total price equal to 100")
	public void testDiscountForEvery100_equals100() {
		ShoppingCart order = new ShoppingCart( new Customer(1, new Date()));
		Product chicken = new Product(1, 100, ProductType.GROCERY);
		order.addOrUpdateItem(new LineItem(1, order, chicken) );
		
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(5, discount);
	}
}
