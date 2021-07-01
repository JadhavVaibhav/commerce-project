package com.tomtom.model;

import lombok.Data;



/**
*  User is person with Single cart and multiple cards
* */
@Data
public class User extends Person {
	private Cart cart;
	private Card card;

	public User(String username, String password, Cart cart) {
		this.username = username;
		this.password = password;
		this.cart = cart;
	}
}
