package com.senebii.core.common;

import java.util.Optional;
import java.util.Set;

import com.senebii.core.cart.LineItem;

public class Utils {
	private Utils() {}
	
	public static double totalOf(Set<LineItem> list) {
		Optional<Double> total = list.stream()
				   .map( op -> op.getProduct().getPrice() * op.getQuantity() )
				   .reduce( (a, b) -> a + b );
		return total.orElse(0.0);
	}
	
}
