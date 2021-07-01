package com.tomtom.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Seller is person with list of products to sell
 */
@Data
public class Seller extends Person {
	Set<Product> productList;

	public Seller(String username, String password, Set<Product> productList) {
		this.productList = productList;
		this.setUsername(username);
		this.setPassword(password);
	}
}
