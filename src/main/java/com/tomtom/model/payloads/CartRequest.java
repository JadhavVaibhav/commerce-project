package com.tomtom.model.payloads;

import com.tomtom.model.Product;
import lombok.Data;

@Data
public class CartRequest {
	Product product;
	String sellerId;
	int qty;

}
