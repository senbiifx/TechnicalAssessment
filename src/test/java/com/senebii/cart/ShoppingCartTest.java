package com.senebii.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.cart.ShoppingCart;
import com.senebii.customer.Customer;
import com.senebii.customer.CustomerType;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

public class ShoppingCartTest {
	
	@Test
	public void testCustomer() {
		Customer c = new Customer(1, new Date());
		ShoppingCart order = new ShoppingCart(c);
		assertEquals(c, order.getCustomer());
	}

	@Test
	public void testSetCustomer() {
		Customer c = new Customer(1, new Date());
		ShoppingCart cart = new ShoppingCart(new Customer(2, new Date()));
		cart.setCustomer(c);
		assertEquals(c, cart.getCustomer());
	}
	
	@Test
	@DisplayName("Add 1 item then validate the amount")
	public void testDiscount() {
		Customer c = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		ShoppingCart cart = new ShoppingCart(c);
		Product product = new Product(1, 100);
		cart.addOrUpdateItem(new LineItem(1, cart, product));
		
		assertEquals(65, cart.getBill().getNetPayableAmount());
	}
	
	@Test
	@DisplayName("Add 2 different items then validate the amount")
	public void testDiscount_2items() {
		Customer c = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		ShoppingCart cart = new ShoppingCart(c);
		Product product = new Product(1, 100);
		Product product2 = new Product(2, 100);
		cart.addOrUpdateItem(new LineItem(1, cart, product));
		cart.addOrUpdateItem(new LineItem(2, cart, product2));
		assertEquals(130, cart.getBill().getNetPayableAmount());
	}
	
	@Test
	@DisplayName("Add 2 items of similar id then validate the amount")
	public void testDiscount_2itemsSimilarId() {
		Customer c = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		ShoppingCart cart = new ShoppingCart(c);
		Product product = new Product(1, 100);
		Product product2 = new Product(1, 100);
		cart.addOrUpdateItem(new LineItem(1, cart, product));
		cart.addOrUpdateItem(new LineItem(2, cart, product2));
		assertEquals(65, cart.getBill().getNetPayableAmount());
	}

}
