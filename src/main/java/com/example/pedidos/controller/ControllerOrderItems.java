package com.example.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedidos.model.OrderItems;
import com.example.pedidos.repository.OrderItemsRepository;
import com.example.pedidos.service.OrderItemsService;

@RestController
@RequestMapping("/order-items")
public class ControllerOrderItems {
	@Autowired
	private OrderItemsService service;
	@Autowired
	private OrderItemsRepository repository;
	
	@GetMapping
	public List<OrderItems> listarTodosPedidos() {
		return service.AllOrderItems();
	}
	@GetMapping("id/{id}")
	public ResponseEntity<OrderItems> listarPorId(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	
	
	
}
