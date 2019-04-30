package com.senebii;

import java.util.Date;

import com.senebii.billing.Bill;
import com.senebii.cart.LineItem;
import com.senebii.cart.ShoppingCart;
import com.senebii.customer.Customer;
import com.senebii.product.Product;

public class Shop {
	public static void main(String[] args) {
			Customer customer = new Customer(1, new Date());
			
			ShoppingCart cart = new ShoppingCart(customer);
			
			Product product = new Product(1, 100);
			
			cart.addOrUpdateItem(new LineItem(1, cart, product));
			
			Bill bill = cart.getBill();
			
			System.out.println("Total amount: " + bill.getTotal());
			System.out.println("Discount: " + bill.getDiscount());
			System.out.println("Net Payable Amount: " + bill.getNetPayableAmount());
	}
}
