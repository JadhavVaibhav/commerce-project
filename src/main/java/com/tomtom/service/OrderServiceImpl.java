package com.tomtom.service;

import com.tomtom.dto.DbService;
import com.tomtom.model.*;
import org.springframework.stereotype.Service;

/**
 *  Should be able to place order, cancel order
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public boolean placeOrder(String userId, Card card) {
		User user = DbService.getUserByName(userId);
		processOrder(user);
		return  true;
	}

	private void processOrder(User user) {
		double total = 0.0;
		for(CartItem cartItem: user.getCart().getCartItems()){
			total += cartItem.getQty() * cartItem.getProduct().getPrice();
			DbService.reduceStock(cartItem.getSellerId(), cartItem.getQty(), cartItem.getProduct().getId());
		}
		user.getCart().setTotal(total);
	}
}
