package com.example.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedidos.model.Orders;
import com.example.pedidos.repository.OrdersRepository;
import com.example.pedidos.service.OrdersService;

@RestController
@RequestMapping("/order")
public class ControllerOrders {
	@Autowired
	private OrdersService service;
	@Autowired
	private OrdersRepository repository;
	
	@GetMapping
	public List<Orders> listarTodosPedidos() {
		return service.AllOrders();
	}
}
