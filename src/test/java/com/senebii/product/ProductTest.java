package com.senebii.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class ProductTest {
	
	
	@Test
	public void testId() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		p.setId(2);
		assertEquals(2, p.getId());
	}
	
	@Test
	public void testPrice() {
		Product p = new Product(1, 2, ProductType.GROCERY);
		p.setPrice(4);
		assertEquals(4, p.getPrice());
	}
	
	@Test
	public void testProductType() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		p.setProductType(ProductType.OTHER);
		assertEquals(ProductType.OTHER, p.getProductType());
	}
	

	@Test
	public void testEquality() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		Product p2 = new Product(1, 1, ProductType.GROCERY);
		assertEquals(p, p2);
	}
	
	@Test
	public void testInequality() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		Product p2 = new Product(2, 1, ProductType.GROCERY);
		assertNotEquals(p, p2);
	}
	
	@Test
	public void testInequalityObject() {
		Product p = new Product(1, 1, ProductType.GROCERY);
		assertNotEquals(p, "");
	}
}
