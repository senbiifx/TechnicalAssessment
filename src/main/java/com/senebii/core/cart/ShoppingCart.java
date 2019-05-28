package com.senebii.core.cart;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import com.senebii.core.billing.Bill;
import com.senebii.core.customer.Customer;
import com.senebii.core.discount.DiscountStrategyFactory;

public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
	 * Adds an item. 
	 * @param item
	 */
	public void addOrUpdateItem(LineItem item) {
		item.setId(nextCountIfNull(item) );
		lineItems.removeIf(i -> i.getId().equals(item.getId()));
		lineItems.add(item);
	}

	private int nextCountIfNull(LineItem item) {
		return item.getId() == null? maxId() + 1: item.getId();
	}

	private int maxId() {
		return lineItems.stream().mapToInt(LineItem::getId).max().orElse(0);
	}
	
	/**
	 * Deletes and item
	 * @param item
	 */
	public void deleteItem(LineItem item) {
		lineItems.remove(item);
	}
	
	public void deleteItem(int id) {
		lineItems.removeIf(item -> item.getId() == id);
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
