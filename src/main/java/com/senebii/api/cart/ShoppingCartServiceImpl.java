package com.senebii.api.cart;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senebii.api.common.ResponseModel;
import com.senebii.api.product.ProductInfoResponse;
import com.senebii.api.product.ProductRepository;
import com.senebii.core.billing.Bill;
import com.senebii.core.cart.LineItem;
import com.senebii.core.cart.ShoppingCart;
import com.senebii.core.product.Product;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ResponseModel<Boolean> saveItem(Integer id, SaveItemRequest request, ShoppingCart cart) {
		Product product = productRepository.getProduct(request.getProductId());
		cart.addOrUpdateItem(new LineItem(id, cart, product, request.getQuantity()));
		return ResponseModel.success(true);
	}

	@Override
	public ResponseModel<List<OrderInfo>> getItems(ShoppingCart cart) {
		Set<LineItem> items = cart.getItems();
		List<OrderInfo> orderInfoList = items.stream()
											 .map(mapToOrderInfo())
											 .collect(Collectors.toList());
		return ResponseModel.success(orderInfoList);
	}

	private Function<? super LineItem, ? extends OrderInfo> mapToOrderInfo() {
		return item -> {
			 OrderInfo order = new OrderInfo();
			 order.setId(item.getId());
			 order.setQuantity(item.getQuantity());
			 order.setProduct(new ProductInfoResponse(item.getProduct().getId(), item.getProduct().getPrice(), item.getProduct().getProductType()));
			 return order;
		 };
	}

	@Override
	public ResponseModel<Boolean> deleteItem(Integer id, ShoppingCart cart) {
		cart.deleteItem(id);
		return ResponseModel.success(true);
	}

	@Override
	public ResponseModel<BillingResponse> getBill(ShoppingCart cart) {
		Bill bill = cart.getBill();
		BillingResponse response = new BillingResponse();
		response.setTotal(bill.getTotal());
		response.setDiscount(bill.getDiscount());
		response.setNetPayableAmount(bill.getNetPayableAmount());
		return ResponseModel.success(response);
	}

}
