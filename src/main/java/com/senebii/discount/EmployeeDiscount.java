package com.senebii.discount;

public class EmployeeDiscount extends BasePercentageDiscount{

	private static final double DISCOUNT = 0.30;

	@Override
	public double calculateNonGroceryItemsDiscount(double total) {
		
		return total * DISCOUNT;
	}
	
}
