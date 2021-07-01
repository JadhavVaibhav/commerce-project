package com.tomtom.service;

import com.tomtom.model.Cart;
import com.tomtom.model.CartItem;

public interface CartService {
	Cart addItemToCart(String Username, CartItem cartItem);
}
