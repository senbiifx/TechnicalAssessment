package com.senebii.api.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senebii.api.common.ResponseModel;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired 
	private ProductRepository repository;
	@Override
	public ResponseModel<List<ProductInfoResponse>> getProducts() {
		List<ProductInfoResponse> list = repository.getProducts()
										   .stream()
										   .map(p -> new ProductInfoResponse(p.getId(), p.getPrice(), p.getProductType()))
										   .collect(Collectors.toList());
		return ResponseModel.success( list );
	}

}
