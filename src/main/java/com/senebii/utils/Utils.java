package com.senebii.utils;

import java.util.List;
import java.util.Optional;

import com.senebii.order.OrderProduct;

public class Utils {
	public static double totalOf(List<OrderProduct> list) {
		Optional<Double> total = list.stream()
				   .map( op -> op.getProduct().getPrice() * op.getQuantity() )
				   .reduce( (a, b) -> a + b );
		return total.get();
	}
	
}
