package com.senebii.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.cart.LineItem;
import com.senebii.cart.ShoppingCart;
import com.senebii.customer.Customer;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

public class AffiliateDiscountTest {
	private DiscountStrategy discountStrategy = new AffiliateDiscount();
	
	@Test
	@DisplayName("Validate discount for 1 product")
	public void testAffiliateDiscount_nonGrocery_1Product() {
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(10, discount);
	}
	
	
	@Test
	@DisplayName("Validate discount for multiple products")
	public void testAffiliateDiscount_nonGrocery_multipleProductsProduct() {
		ShoppingCart order = new ShoppingCart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 100, ProductType.OTHER);
		order.addOrUpdateItem(new LineItem(1, order, product));
		order.addOrUpdateItem( new LineItem(2, order, product2));
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(20, discount);
	}
	
	
}
