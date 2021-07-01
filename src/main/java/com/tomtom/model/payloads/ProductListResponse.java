package com.tomtom.model.payloads;

import com.tomtom.model.Product;
import lombok.Data;

import java.util.Set;

@Data
public class ProductListResponse {
	public String sellerName;
	public Set<Product> productSet;

}
