package com.tomtom.service;

import com.tomtom.dto.DbService;
import com.tomtom.model.Product;
import com.tomtom.model.Seller;
import com.tomtom.model.payloads.ProductListResponse;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
	@Override
	public Set<Product> addProduct(String sellerID, Product product) {
		Seller seller = DbService.getSellerByUsername(sellerID);
		if (seller != null) {
			seller.getProductList().add(product);
			return seller.getProductList();
		}
		return null;
	}

	@Override
	public Set<ProductListResponse> getListOfProducts() {
		Set<ProductListResponse> productListResponses = new HashSet<>();
		DbService.sellerList.forEach(seller -> {
			ProductListResponse productListResponse = new ProductListResponse();
			productListResponse.setSellerName(seller.username);
			productListResponse.setProductSet(seller.getProductList());
			productListResponses.add(productListResponse);
		});
		return productListResponses;
	}
}
