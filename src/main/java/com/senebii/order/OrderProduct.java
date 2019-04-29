package com.senebii.order;

import com.senebii.product.Product;

public class OrderProduct {
	private int id;
	private Order order;
	private Product product;;
	private int quantity;
	
	
	public OrderProduct(int id, Order order, Product product, int quantity) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	
	
	public OrderProduct(int id, Order order, Product product) {
		this(id, order, product, 1);
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
