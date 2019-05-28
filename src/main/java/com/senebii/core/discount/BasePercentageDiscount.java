package com.senebii.core.discount;

import java.util.List;
import java.util.stream.Collectors;

import com.senebii.core.cart.LineItem;
import com.senebii.core.cart.ShoppingCart;
import com.senebii.core.product.ProductType;

public abstract class BasePercentageDiscount implements DiscountStrategy{

	@Override
	public double calculateDiscount(ShoppingCart order) {
		List<LineItem> nonGroceryItems = order.getItems().stream()
												  .filter(op -> op.getProduct().getProductType() != ProductType.GROCERY)
												  .collect(Collectors.toList());
		
		double total = nonGroceryItems.stream()
									   .map( op -> op.getProduct().getPrice() * op.getQuantity() )
									   .reduce( (a, b) -> a + b )
									   .orElse(0.0);
		
		return calculateNonGroceryItemsDiscount(total);
	}
	
	public abstract double calculateNonGroceryItemsDiscount(double total);
	
}
