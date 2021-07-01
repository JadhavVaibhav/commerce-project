package com.tomtom.model;

import lombok.Data;

@Data
public class Card {
	private String cardNumber;
	private String expDate;
	private int cvv;
}
