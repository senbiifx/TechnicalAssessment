package com.senebii.cart;

import java.util.LinkedHashSet;
import java.util.Set;

import com.senebii.billing.Bill;
import com.senebii.customer.Customer;
import com.senebii.discount.DiscountStrategyFactory;

public class ShoppingCart {
	private Set<LineItem> lineItems;
	private Customer customer;
	
	public ShoppingCart(Customer customer) {
		this.customer = customer;
		this.lineItems = new LinkedHashSet<>();
	}
	
	/**
	 * Calculates the bill
	 * @return
	 */
	public Bill getBill() {
		return new Bill(this, DiscountStrategyFactory.getDiscountStrategy(customer));
	}
	
	/**
	 * Adds an item. If the item already exists(based on the id), item is updated.
	 * @param item
	 */
	public void addOrUpdateItem(LineItem item) {
		lineItems.add(item);
	}
	
	/**
	 * Deletes and item
	 * @param item
	 */
	public void deleteItem(LineItem item) {
		lineItems.remove(item);
	}
	
	public Set<LineItem> getItems() {
		return lineItems;
	}
	
	/**
	 * Gets the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Sets the customer
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
