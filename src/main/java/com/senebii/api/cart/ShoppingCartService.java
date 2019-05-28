package com.senebii.api.cart;

import java.util.List;

import com.senebii.api.common.ResponseModel;
import com.senebii.core.cart.ShoppingCart;


public interface ShoppingCartService {
	public ResponseModel<Boolean> saveItem(Integer id, SaveItemRequest request, ShoppingCart cart);
	public ResponseModel<List<OrderInfo>> getItems(ShoppingCart cart);
	public ResponseModel<Boolean> deleteItem(Integer id, ShoppingCart cart);
	public ResponseModel<BillingResponse> getBill(ShoppingCart cart);
}
