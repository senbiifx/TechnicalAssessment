package com.senebii.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.senebii.customer.Customer;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

public class OrderProductTest {

	
	@Test
	public void testSetID() {
		Order order = new Order(1, new Customer(1, new Date()));
		Product p = new Product(1, 1, ProductType.GROCERY);
		OrderProduct op = new OrderProduct(1, order, p);
		op.setId(2);
		assertEquals(2, op.getId());
	}
	
	@Test
	public void testOrder() {
		Order order = new Order(1, new Customer(1, new Date()));
		Order order2 = new Order(2, new Customer(1, new Date()));
		Product p = new Product(1, 1, ProductType.GROCERY);
		OrderProduct op = new OrderProduct(1, order, p);
		op.setOrder(order2);
		assertEquals(order2, op.getOrder());
	}
	
	@Test
	public void testProduct() {
		Order order = new Order(1, new Customer(1, new Date()));
		Product p = new Product(1, 1, ProductType.GROCERY);
		Product p2 = new Product(1, 1, ProductType.GROCERY);
		OrderProduct op = new OrderProduct(1, order, p);
		op.setProduct(p2);
		assertEquals(p2, op.getProduct());
	}
	
	@Test
	public void testQuantity() {
		Order order = new Order(1, new Customer(1, new Date()));
		Product p = new Product(1, 1, ProductType.GROCERY);
		OrderProduct op = new OrderProduct(1, order, p);
		op.setQuantity(3);
		assertEquals(3, op.getQuantity());
	}
}

