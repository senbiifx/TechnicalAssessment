package com.senebii.api.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.senebii.api.common.Constants;
import com.senebii.api.common.ResponseModel;
import com.senebii.core.cart.ShoppingCart;

@RestController
@RequestMapping(("/cart"))
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PostMapping("/save/{id}")
	public ResponseModel saveItem(@PathVariable(name = "id") Integer id, 
										   @RequestBody SaveItemRequest saveItemRequest, 
										   @SessionAttribute(name = Constants.SESSION_SHOPPINGCART) ShoppingCart cart) {
		return shoppingCartService.saveItem(id, saveItemRequest, cart);
	}
	
	@PostMapping("/add")
	public ResponseModel addItem( @RequestBody SaveItemRequest saveItemRequest, 
										   @SessionAttribute(name = Constants.SESSION_SHOPPINGCART) ShoppingCart cart) {
		return shoppingCartService.saveItem(null, saveItemRequest, cart);
	}
	
	@GetMapping("/list")
	public ResponseModel getItems(@SessionAttribute(name = Constants.SESSION_SHOPPINGCART) ShoppingCart cart) {
		return shoppingCartService.getItems(cart);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseModel deleteItem(@PathVariable("id")Integer id, @SessionAttribute(name = Constants.SESSION_SHOPPINGCART) ShoppingCart cart) {
		return shoppingCartService.deleteItem(id, cart);
	}
	
	@GetMapping("/bill")
	public ResponseModel getBill(@SessionAttribute(name = Constants.SESSION_SHOPPINGCART) ShoppingCart cart){
		return shoppingCartService.getBill(cart);
	}
	
}

