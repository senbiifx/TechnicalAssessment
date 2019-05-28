package com.senebii.core.discount;

import com.senebii.core.cart.ShoppingCart;
import com.senebii.core.common.Utils;

public class DiscountForEvery100 implements DiscountStrategy{

	private static final double DISCOUNT = 5;
	private static final double FOREVERYAMOUNT = 100;
	private DiscountStrategy discountStrategy;
	
	public DiscountForEvery100(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}
	
	public DiscountForEvery100() {
		this.discountStrategy = n -> 0;
	}

	public double calculateDiscount(ShoppingCart order) {
		double total = Utils.totalOf(order.getItems());
		
		int multiplier = (int) (total / FOREVERYAMOUNT);
		double totalDiscount = DISCOUNT * multiplier;
		return totalDiscount + discountStrategy.calculateDiscount(order);
	}

	
}
