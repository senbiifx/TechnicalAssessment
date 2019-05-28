package com.senebii.core.discount;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.core.customer.Customer;
import com.senebii.core.customer.CustomerType;

public class DiscountStrategyFactoryTest {
	
	@Test
	@DisplayName("Validate discount strategy for Employee")
	public void testDiscountStrategyFactory_employee() {
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		assertTrue( discountStrategy instanceof DiscountStrategy );
	}
	
	@Test
	@DisplayName("Validate discount strategy for Affiliates")
	public void testDiscountStrategyFactory_affiliate() {
		Customer customer = new Customer(1, new Date(), CustomerType.AFFILIATE);
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		assertTrue( discountStrategy instanceof DiscountStrategy );
	}
	
	@Test
	@DisplayName("Validate discount strategy for Regular Customers")
	public void testDiscountStrategyFactory_regular() {
		Customer customer = new Customer(1, new Date(), CustomerType.REGULAR);
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		assertTrue( discountStrategy instanceof DiscountStrategy );
	}
	

}
