package com.senebii.order;

import java.util.ArrayList;
import java.util.List;

import com.senebii.customer.Customer;

public class Order {
	private int id;
	private List<OrderProduct> orderProducts;
	private Customer customer;
	public Order(int id, Customer customer) {
		this.id = id;
		this.customer = customer;
		this.orderProducts = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addOrderProduct(OrderProduct orderProduct) {
		orderProducts.add(orderProduct);
	}
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
