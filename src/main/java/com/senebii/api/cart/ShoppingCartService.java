package com.senebii.api.cart;

import com.senebii.api.common.ResponseModel;
import com.senebii.core.cart.ShoppingCart;


public interface ShoppingCartService {
	public ResponseModel saveItem(Integer id, SaveItemRequest request, ShoppingCart cart);
	public ResponseModel getItems(ShoppingCart cart);
	public ResponseModel deleteItem(Integer id, ShoppingCart cart);
	public ResponseModel getBill(ShoppingCart cart);
}
