package com.senebii.discount;

import com.senebii.cart.ShoppingCart;
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

	public double calculateDiscount(ShoppingCart order) {
		double total = Utils.totalOf(order.getItems());
		
		int multiplier = (int) (total / FOREVERYAMOUNT);
		double totalDiscount = DISCOUNT * multiplier;
		return totalDiscount + discountStrategy.calculateDiscount(order);
	}

	
}
