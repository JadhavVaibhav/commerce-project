package com.tomtom.service;

import com.tomtom.model.Card;
import com.tomtom.model.Cart;

public interface OrderService {
	boolean placeOrder(String userId, Card card);
}
