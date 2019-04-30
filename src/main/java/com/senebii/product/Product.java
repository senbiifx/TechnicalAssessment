package com.senebii.product;

public class Product {
	private Integer id;
	private double price;
	private ProductType productType;
	
	public Product(int id, double price, ProductType productType) {
		this.id = id;
		this.price = price;
		this.productType = productType;
	}
	
	public Product(int id, double price) {
		this(id, price, ProductType.OTHER);
	}
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	
	
}
