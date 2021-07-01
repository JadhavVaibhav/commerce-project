package com.tomtom.dto;

import com.tomtom.model.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class DbService {
	public static List<Seller> sellerList = new ArrayList<>();
	public static List<User> userList = new ArrayList<>();

	static {
		sellerList.add(new Seller("Seller1","Seller1Pass", new HashSet<>()));
		sellerList.add(new Seller("Seller2","Seller2Pass", new HashSet<>()));
		userList.add(new User("User1","User1Pass", new Cart(new HashSet<>())));
		userList.add(new User("User2","User2Pass", new Cart(new HashSet<>())));
	}

	public static Seller getSellerByUsername(String username){
		for(Seller seller : sellerList){
			if(seller.getUsername().equals(username))
				return seller;
		}
		return null;
	}

	public static Product getProductByIdAndSeller (int prodId, Seller seller){
		for(Product product : seller.getProductList()){
			if(product.getId() == prodId){
				return product;
			}
		}
		return null;
	}

	public static User getUserByName(String username) {
		for(User user : userList){
			if(user.getUsername().equals(username))
				return user;
		}
		return null;
	}


	public static void reduceStock(String sellerId, int qty, int prouctId) {
		Seller seller = getSellerByUsername(sellerId);
		for(Product product : seller.getProductList()){
			if(product.getId()==prouctId)
				product.setStockQty(product.getStockQty() - qty);
		}
	}
}
