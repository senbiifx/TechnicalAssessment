package com.senebii.core.discount;

import com.senebii.core.cart.ShoppingCart;

@FunctionalInterface
public interface DiscountStrategy {
	public double calculateDiscount(ShoppingCart order);
}
