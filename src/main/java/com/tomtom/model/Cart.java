package com.tomtom.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *  cart contains multiple cartItem and total pricing for it
 */
@Data
public class Cart {
	 Set<CartItem> cartItems;
	 double total;

	public Cart(){

	}
	public Cart(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}
