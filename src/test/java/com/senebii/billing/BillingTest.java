package com.senebii.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.cart.LineItem;
import com.senebii.cart.ShoppingCart;
import com.senebii.customer.Customer;
import com.senebii.customer.CustomerType;
import com.senebii.discount.DiscountStrategy;
import com.senebii.discount.DiscountStrategyFactory;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

public class BillingTest {
	
	@Test
	@DisplayName("Validate that getDiscount() returns the proper value given a discount strategy. ")
	public void testGetDiscount() {
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		ShoppingCart order = new ShoppingCart(customer);
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Bill billing = new Bill(order, discountStrategy);
		
		double discount = billing.getDiscount();
		
		assertEquals(35, discount);
	}
	
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is an EMPLOYEE")
	public void testGetNetPayableAmount_employee() {
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		ShoppingCart order = new ShoppingCart(customer);
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Bill billing = new Bill(order, discountStrategy);
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(65, netPayableAmount);
	}
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is an AFFILIATE")
	public void testGetNetPayableAmount_affiliate() {
		Customer customer = new Customer(1, new Date(), CustomerType.AFFILIATE);
		ShoppingCart order = new ShoppingCart(customer);
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Bill billing = new Bill(order, discountStrategy);
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(85, netPayableAmount);
	}
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is a REGULAR CUSTOMER with less than 2 years joining date")
	public void testGetNetPayableAmount_regularCustomer_lessThan2YearsJoiningDate() {
		Customer customer = new Customer(1, new Date(), CustomerType.REGULAR);
		ShoppingCart order = new ShoppingCart(customer);
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Bill billing = new Bill(order, discountStrategy);
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(95, netPayableAmount);
	}
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is a REGULAR CUSTOMER with more than 2 years joining date")
	public void testGetNetPayableAmount_regularCustomer_moreThan2YearsJoiningDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 3);
		Customer customer = new Customer(1, calendar.getTime(), CustomerType.REGULAR);
		ShoppingCart order = new ShoppingCart(customer);
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Bill billing = new Bill(order, discountStrategy);
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(95, netPayableAmount);
	}
	
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() for multiple non-grocery products")
	public void testGetNetPayableAmount_multipleProducts() {
		Customer customer = new Customer(1, new Date(), CustomerType.REGULAR);
		ShoppingCart order = new ShoppingCart(customer);
		Product product1 = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product1));
		order.addOrUpdateItem(new LineItem(2, order, product2));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Bill billing = new Bill(order, discountStrategy);
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(190, netPayableAmount);
	}
	
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() for multiple grocery products")
	public void testGetNetPayableAmount_multipleGroceryProducts() {
		Customer customer = new Customer(1, new Date(), CustomerType.REGULAR);
		ShoppingCart order = new ShoppingCart(customer);
		Product product1 = new Product(1, 100, ProductType.GROCERY);
		Product product2 = new Product(2, 100, ProductType.GROCERY);
		order.addOrUpdateItem(new LineItem(1, order, product1));
		order.addOrUpdateItem(new LineItem(2, order, product2));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Bill billing = new Bill(order, discountStrategy);
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(190, netPayableAmount);
	}
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() for assorted products")
	public void testGetNetPayableAmount_assortedProducts() {
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		ShoppingCart order = new ShoppingCart(customer);
		Product product1 = new Product(1, 100, ProductType.GROCERY);
		Product product2 = new Product(2, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product1));
		order.addOrUpdateItem(new LineItem(2, order, product2));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Bill billing = new Bill(order, discountStrategy);
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(160, netPayableAmount);
	}
	
	
}
