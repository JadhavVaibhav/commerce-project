package com.tomtom.model;

import lombok.Data;

import java.util.Objects;

/**
 * cart item is product and quantity along with seller id from whom user is purchasing product
 */
@Data
public class CartItem {
	private Product product;
	private String sellerId;
	int qty;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CartItem)) return false;
		CartItem cartItem = (CartItem) o;
		return qty == cartItem.qty && Objects.equals(product, cartItem.product) && Objects.equals(sellerId, cartItem.sellerId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, sellerId, qty);
	}
}
