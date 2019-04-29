package com.senebii.billing;

import java.util.Collections;
import java.util.List;

import com.senebii.discount.DiscountStrategy;
import com.senebii.order.OrderProduct;
import com.senebii.utils.Utils;

public class Billing {
	
	private List<OrderProduct> orderProducts;
	private double discount;
	private DiscountStrategy discountStrategy;
	
	public Billing(List<OrderProduct> orderProducts, DiscountStrategy discountStrategy) {
		this.orderProducts = Collections.unmodifiableList( orderProducts ); //defensive copy
		discount = discountStrategy.calculateDiscount(orderProducts);
		this.discountStrategy = discountStrategy;
	}

	public double getDiscount() {
		return discount;
	}
	
	public double getNetPayableAmount() {
		return Utils.totalOf(orderProducts) - discount;
	}
	
}
