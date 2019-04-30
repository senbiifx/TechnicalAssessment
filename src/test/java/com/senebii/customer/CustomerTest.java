package com.senebii.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class CustomerTest {
	@Test
	public void testId() {
		Customer customer = new Customer(1, new Date());
		customer.setId(2);
		assertEquals(2, customer.getId());
	}
	
	@Test
	public void testDate() {
		Date date = new Date();
		Customer customer = new Customer(1, new Date());
		customer.setJoinDate(date);
		assertEquals(date, customer.getJoinDate());
	}
	
	@Test
	public void testSetCustomerType() {
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		customer.setType(CustomerType.AFFILIATE);
		assertEquals(CustomerType.AFFILIATE, customer.getType());
	}
}
