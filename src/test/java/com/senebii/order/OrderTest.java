package com.senebii.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.senebii.customer.Customer;

public class OrderTest {
	@Test
	public void testId() {
		Order order = new Order(1, new Customer(1, new Date()));
		order.setId(3);
		assertEquals(3, order.getId());
	}
	
	@Test
	public void testCustomer() {
		Customer c = new Customer(1, new Date());
		Order order = new Order(1, c);
		assertEquals(c, order.getCustomer());
	}

	@Test
	public void testSetCustomer() {
		Customer c = new Customer(1, new Date());
		Order order = new Order(1, new Customer(2, new Date()));
		order.setCustomer(c);
		assertEquals(c, order.getCustomer());
	}

}
