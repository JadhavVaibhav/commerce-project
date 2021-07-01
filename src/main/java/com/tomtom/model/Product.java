package com.tomtom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Each product has id,name and price and list of sellers associated with it. As single product can be sold by multiple sellers.
 */
@Setter
public class Product {
	private int id;
	private String name;
	private double price;
	private int stockQty;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

//	@JsonIgnore
	public int getStockQty() {
		return stockQty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return id == product.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
