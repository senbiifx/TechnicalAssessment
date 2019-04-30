package com.senebii.discount;

import com.senebii.order.Order;
import com.senebii.utils.Utils;

public class DiscountForEvery100 implements DiscountStrategy{

	private double DISCOUNT = 5;
	private double FOREVERYAMOUNT = 100;
	private DiscountStrategy discountStrategy;
	
	public DiscountForEvery100(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}
	
	public DiscountForEvery100() {
		this.discountStrategy = n -> 0;
	}

	public double calculateDiscount(Order order) {
		double total = Utils.totalOf(order.getOrderProducts());
		
		int multiplier = (int) (total / FOREVERYAMOUNT);
		double totalDiscount = DISCOUNT * multiplier;
		return totalDiscount + discountStrategy.calculateDiscount(order);
	}

	
}
