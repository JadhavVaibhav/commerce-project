package com.tomtom.service;

import com.tomtom.model.Product;
import com.tomtom.model.Seller;
import com.tomtom.model.payloads.ProductListResponse;

import java.util.List;
import java.util.Set;

public interface ProductService {
	Set<Product> addProduct(String username , Product product);
	Set<ProductListResponse> getListOfProducts();
}
