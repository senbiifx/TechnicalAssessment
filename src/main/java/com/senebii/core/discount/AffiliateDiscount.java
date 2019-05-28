package com.senebii.core.discount;

public class AffiliateDiscount extends BasePercentageDiscount{
	private static final double DISCOUNT = .10;

	@Override
	public double calculateNonGroceryItemsDiscount(double total) {
		return total * DISCOUNT;
	}
	
}
