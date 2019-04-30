package com.senebii.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.senebii.cart.LineItem;
import com.senebii.cart.ShoppingCart;
import com.senebii.customer.Customer;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

public class LineItemTest {

	
	@Test
	public void testSetID() {
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product p = new Product(1, 1, ProductType.GROCERY);
		LineItem op = new LineItem(1, order, p);
		op.setId(2);
		assertEquals(2, op.getId());
	}
	
	@Test
	public void testOrder() {
		ShoppingCart cart = new ShoppingCart(new Customer(1, new Date()));
		ShoppingCart cart2 = new ShoppingCart(new Customer(1, new Date()));
		Product p = new Product(1, 1, ProductType.GROCERY);
		LineItem op = new LineItem(1, cart, p);
		op.setCart(cart2);
		assertEquals(cart2, op.getCart());
	}
	
	@Test
	public void testProduct() {
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product p = new Product(1, 1, ProductType.GROCERY);
		Product p2 = new Product(1, 1, ProductType.GROCERY);
		LineItem op = new LineItem(1, order, p);
		op.setProduct(p2);
		assertEquals(p2, op.getProduct());
	}
	
	@Test
	public void testQuantity() {
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product p = new Product(1, 1, ProductType.GROCERY);
		LineItem op = new LineItem(1, order, p);
		op.setQuantity(3);
		assertEquals(3, op.getQuantity());
	}
	
	@Test
	public void testEquality() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		LineItem op = new LineItem(1, null, p);
		LineItem op2 = new LineItem(1, null, p);
		assertEquals(op, op2);
	}
	
	@Test
	public void testInEqualityProduct() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		Product p2 = new Product(2, 1, ProductType.GROCERY);
		LineItem op = new LineItem(1, null, p);
		LineItem op2 = new LineItem(2, null, p2);
		assertNotEquals(op, op2);
	}
	
	@Test
	public void testEqualityOtherObj() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		LineItem op = new LineItem(1, null, p);
		assertNotEquals(op, "");
	}
	
	@Test
	public void testInequality() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		LineItem op = new LineItem(1, null, p);
		assertNotEquals(op, "");
	}

}

