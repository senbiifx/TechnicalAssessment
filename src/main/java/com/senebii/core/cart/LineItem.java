package com.senebii.core.cart;

import java.io.Serializable;

import com.senebii.core.product.Product;

public class LineItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private ShoppingCart order;
	private Product product;
	private int quantity;
	
	public LineItem(Integer id, ShoppingCart cart, Product product, int quantity) {
		this.id = id;
		this.order = cart;
		this.product = product;
		this.quantity = quantity;
	}
	
	public LineItem(int id, ShoppingCart order, Product product) {
		this(id, order, product, 1);
	}

	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ShoppingCart getCart() {
		return order;
	}
	public void setCart(ShoppingCart order) {
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof LineItem) {
			LineItem other = (LineItem) obj;
			return other.product.getId() == product.getId();
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return product.hashCode();
	}
	

}
