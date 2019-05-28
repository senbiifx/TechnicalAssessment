package com.senebii.api.product;

import com.senebii.core.product.ProductType;

public class ProductInfoResponse {
	private Integer id;
	private double price;
	private ProductType productType;
	
	
	public ProductInfoResponse(Integer id, double price, ProductType productType) {
		super();
		this.id = id;
		this.price = price;
		this.productType = productType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
}
