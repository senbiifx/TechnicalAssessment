package com.senebii.utils;

import java.util.Optional;
import java.util.Set;

import com.senebii.cart.LineItem;

public class Utils {
	public static double totalOf(Set<LineItem> list) {
		Optional<Double> total = list.stream()
				   .map( op -> op.getProduct().getPrice() * op.getQuantity() )
				   .reduce( (a, b) -> a + b );
		return total.get();
	}
	
}
