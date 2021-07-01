package com.tomtom.controller;

import com.tomtom.model.Card;
import com.tomtom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping(value = "/order")
	public ResponseEntity<Object> placeOrder(@RequestParam String username, @RequestBody Card card) {
		return new ResponseEntity<>(orderService.placeOrder(username, card), HttpStatus.ACCEPTED);
	}
}
