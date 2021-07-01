package com.tomtom.service;

import com.tomtom.dto.DbService;
import com.tomtom.model.Cart;
import com.tomtom.model.CartItem;
import com.tomtom.model.Seller;
import com.tomtom.model.User;
import org.springframework.stereotype.Service;

@Service
public class CartServcieImpl implements CartService {

	@Override
	public Cart addItemToCart(String username, CartItem cartItem) {
		Seller seller = DbService.getSellerByUsername(cartItem.getSellerId());
		User user = DbService.getUserByName(username);
		if(seller.getProductList().contains(cartItem.getProduct()) && user != null) {
				cartItem.setProduct(DbService.getProductByIdAndSeller(cartItem.getProduct().getId(), seller));
				user.getCart().getCartItems().add(cartItem);
				processOrder(user.getCart());
				return user.getCart();

		}
		return null;
	}

	private void processOrder(Cart cart) {
		double total = 0.0;
		for(CartItem cartItem: cart.getCartItems()){
			total += cartItem.getQty() * cartItem.getProduct().getPrice();
		}
		cart.setTotal(total);

	}
}
