package com.senebii.api.product;

import java.util.List;

import com.senebii.api.common.ResponseModel;

public interface ProductService {
	public ResponseModel<List<ProductInfoResponse>> getProducts();
	
}
