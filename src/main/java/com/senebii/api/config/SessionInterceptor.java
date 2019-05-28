package com.senebii.api.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.senebii.api.common.Constants;
import com.senebii.core.cart.ShoppingCart;
import com.senebii.core.customer.Customer;
import com.senebii.core.customer.CustomerType;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(true);
		if (session.getAttribute(Constants.SESSION_SHOPPINGCART) == null) {
			
			Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
			
			session.setAttribute(Constants.SESSION_SHOPPINGCART, new ShoppingCart(customer));
		}
		return true;
	}
}
