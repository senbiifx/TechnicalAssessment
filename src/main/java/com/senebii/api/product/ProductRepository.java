package com.senebii.api.product;

import java.util.List;

import com.senebii.core.product.Product;

public interface ProductRepository {
	public Product getProduct(Integer id);
	public List<Product> getProducts();
}
