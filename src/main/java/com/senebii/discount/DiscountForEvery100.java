package com.senebii.discount;

import java.util.List;

import com.senebii.order.OrderProduct;
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

	public double calculateDiscount(List<OrderProduct> list) {
		double total = Utils.totalOf(list);
		
		int multiplier = (int) (total / FOREVERYAMOUNT);
		double totalDiscount = DISCOUNT * multiplier;
		return totalDiscount + discountStrategy.calculateDiscount(list);
	}

	
}
