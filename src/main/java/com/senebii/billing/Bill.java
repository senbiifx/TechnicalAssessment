package com.senebii.billing;

import com.senebii.cart.ShoppingCart;
import com.senebii.discount.DiscountStrategy;
import com.senebii.utils.Utils;

public class Bill {
	
	private DiscountStrategy discountStrategy;
	private ShoppingCart order;
	public Bill(ShoppingCart cart, DiscountStrategy discountStrategy) {
		this.order = cart; //defensive copy
		this.discountStrategy = discountStrategy;
	}

	/**
	 * Returns the discount amount the customer is entitled to
	 * @return
	 */
	public double getDiscount() {
		return discountStrategy.calculateDiscount(order);
	}
	
	/**
	 * gets the total amount(before discount)
	 * @return
	 */
	public double getTotal() {
		return Utils.totalOf(order.getItems());
	}
	
	/**gets the total amount(after discount)
	 * @return
	 */
	public double getNetPayableAmount() {
		return getTotal() - getDiscount();
	}
	
}
