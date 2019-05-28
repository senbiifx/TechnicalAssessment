package com.senebii.api.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.senebii.core.product.Product;
import com.senebii.core.product.ProductType;

@Repository
public class ProductRepositoryMockData implements ProductRepository{

	private Map<Integer, Product> products = new HashMap<>();
	
	@PostConstruct
	private void init() {
		products.put(1, new Product(1, 100, ProductType.GROCERY));
		products.put(2, new Product(2, 90, ProductType.GROCERY));
		products.put(3, new Product(3, 80, ProductType.GROCERY));
		products.put(4, new Product(4, 70, ProductType.OTHER));
		products.put(5, new Product(5, 60, ProductType.OTHER));
		products.put(6, new Product(6, 60, ProductType.OTHER));
		products.put(7, new Product(7, 60, ProductType.OTHER));
		products.put(8, new Product(8, 60, ProductType.OTHER));
	}
	
	@Override
	public Product getProduct(Integer id) {
		return products.get(id);
	}

	@Override
	public List<Product> getProducts() {
		return new ArrayList<>(products.values());
	}

}
