package com.senebii.discount;

import com.senebii.cart.ShoppingCart;

@FunctionalInterface
public interface DiscountStrategy {
	public double calculateDiscount(ShoppingCart order);
}
