package com.senebii.discount;

import java.util.List;

import com.senebii.order.OrderProduct;

@FunctionalInterface
public interface DiscountStrategy {
	public double calculateDiscount(List<OrderProduct> list);
}
