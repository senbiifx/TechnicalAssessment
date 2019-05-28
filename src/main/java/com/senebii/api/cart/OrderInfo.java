package com.senebii.api.cart;

import com.senebii.api.product.ProductInfoResponse;

public class OrderInfo {
	private Integer id;
	private ProductInfoResponse product;
	private int quantity;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductInfoResponse getProduct() {
		return product;
	}
	public void setProduct(ProductInfoResponse product) {
		this.product = product;
	}
	
}
