package com.senebii.core.discount;

import com.senebii.core.customer.Customer;
import com.senebii.core.customer.CustomerType;

public class DiscountStrategyFactory {
	
	private DiscountStrategyFactory() {
		
	}
	
	public static DiscountStrategy getDiscountStrategy(Customer customer) {
		if( customer.getType() == CustomerType.EMPLOYEE  ) {
			return new DiscountForEvery100( new EmployeeDiscount() );
			
		}else if ( customer.getType() == CustomerType.AFFILIATE ) {
			return new DiscountForEvery100( new AffiliateDiscount() );
			
		}else {
			return new DiscountForEvery100( new RegularCustomerDiscount( customer ) );
		}
		
	}
}
