package com.senebii.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.customer.Customer;
import com.senebii.customer.CustomerType;
import com.senebii.discount.DiscountStrategy;
import com.senebii.discount.DiscountStrategyFactory;
import com.senebii.order.Order;
import com.senebii.order.OrderProduct;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

public class BillingTest {
	
	@Test
	@DisplayName("Validate that getDiscount() returns the proper value given a discount strategy. ")
	public void testGetDiscount() {
		Order order = new Order(1);
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		Product product = new Product(1, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		double discount = billing.getDiscount();
		
		assertEquals(35, discount);
	}
	
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is an EMPLOYEE")
	public void testGetNetPayableAmount_employee() {
		Order order = new Order(1);
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		Product product = new Product(1, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(65, netPayableAmount);
	}
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is an AFFILIATE")
	public void testGetNetPayableAmount_affiliate() {
		Order order = new Order(1);
		Customer customer = new Customer(1, new Date(), CustomerType.AFFILIATE);
		Product product = new Product(1, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(85, netPayableAmount);
	}
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is a REGULAR CUSTOMER with less than 2 years joining date")
	public void testGetNetPayableAmount_regularCustomer_lessThan2YearsJoiningDate() {
		Order order = new Order(1);
		Customer customer = new Customer(1, new Date(), CustomerType.REGULAR);
		Product product = new Product(1, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(95, netPayableAmount);
	}
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is a REGULAR CUSTOMER with more than 2 years joining date")
	public void testGetNetPayableAmount_regularCustomer_moreThan2YearsJoiningDate() {
		Order order = new Order(1);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 3);
		Customer customer = new Customer(1, calendar.getTime(), CustomerType.REGULAR);
		Product product = new Product(1, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(90, netPayableAmount);
	}
	
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() returns the proper value if the customer is an both an AFFILIATE and EMPLOYEE")
	public void testGetNetPayableAmount_multipleRoles() {
		Order order = new Order(1);
		Customer customer = new Customer(1, new Date(), CustomerType.AFFILIATE, CustomerType.EMPLOYEE);
		Product product = new Product(1, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(65, netPayableAmount);
	}
	
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() for multiple non-grocery products")
	public void testGetNetPayableAmount_multipleProducts() {
		Order order = new Order(1);
		Customer customer = new Customer(1, new Date(), CustomerType.REGULAR);
		Product product1 = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(1, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product1), new OrderProduct(2, order, product2));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(190, netPayableAmount);
	}
	
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() for multiple grocery products")
	public void testGetNetPayableAmount_multipleGroceryProducts() {
		Order order = new Order(1);
		Customer customer = new Customer(1, new Date(), CustomerType.REGULAR);
		Product product1 = new Product(1, 100, ProductType.GROCERY);
		Product product2 = new Product(2, 100, ProductType.GROCERY);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product1), new OrderProduct(2, order, product2));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(190, netPayableAmount);
	}
	
	@Test
	@DisplayName("Validate that getNetPayableAmount() for assorted products")
	public void testGetNetPayableAmount_assortedProducts() {
		Order order = new Order(1);
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		Product product1 = new Product(1, 100, ProductType.GROCERY);
		Product product2 = new Product(2, 100, ProductType.OTHER);
		List<OrderProduct> orderProducts = Arrays.asList(new OrderProduct(1, order, product1), new OrderProduct(2, order, product2));
		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(customer);
		Billing billing = new Billing(orderProducts, discountStrategy);
		
		
		double netPayableAmount = billing.getNetPayableAmount();
		
		assertEquals(160, netPayableAmount);
	}
	
	
}
