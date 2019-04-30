package com.senebii.cart;

import com.senebii.product.Product;

public class LineItem {
	private Integer id;
	private ShoppingCart order;
	private Product product;;
	private int quantity;
	
	public LineItem(int id, ShoppingCart cart, Product product, int quantity) {
		this.id = id;
		this.order = cart;
		this.product = product;
		this.quantity = quantity;
	}
	
	public LineItem(int id, ShoppingCart order, Product product) {
		this(id, order, product, 1);
	}

	public int getId() {
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
		return product.getId().hashCode();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
