package com.senebii.billing;

import com.senebii.discount.DiscountStrategy;
import com.senebii.order.Order;
import com.senebii.utils.Utils;

public class Billing {
	
	private double discount;
	private DiscountStrategy discountStrategy;
	private Order order;
	public Billing(Order order, DiscountStrategy discountStrategy) {
		this.order = order; //defensive copy
		discount = discountStrategy.calculateDiscount(order);
		this.discountStrategy = discountStrategy;
	}

	public double getDiscount() {
		return discount;
	}
	
	public double getNetPayableAmount() {
		return Utils.totalOf(order.getOrderProducts()) - discount;
	}
	
}
