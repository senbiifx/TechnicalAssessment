package com.senebii.core.discount;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.senebii.core.customer.Customer;

public class RegularCustomerDiscount extends BasePercentageDiscount{

	private static final int YEARS = 2;
	private Customer customer;

	
	public RegularCustomerDiscount(Customer customer) {
		this.customer = customer;
	}

	@Override
	public double calculateNonGroceryItemsDiscount(double total) {
		if( isOverNYears(customer.getJoinDate(), YEARS) ) {
			return total * .05;
		}else {
			return 0;
		}
	}
	
	private boolean isOverNYears(Date date, int n) {
		LocalDateTime joinDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime twoYearsaGO = now.minusYears(n);
		
		return joinDate.isBefore(twoYearsaGO) || joinDate.isEqual(twoYearsaGO);
	}
	
}
