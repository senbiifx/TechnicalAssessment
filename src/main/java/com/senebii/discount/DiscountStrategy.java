package com.senebii.discount;

import com.senebii.order.Order;

@FunctionalInterface
public interface DiscountStrategy {
	public double calculateDiscount(Order order);
}
