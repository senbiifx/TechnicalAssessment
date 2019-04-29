package com.senebii.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	

}
