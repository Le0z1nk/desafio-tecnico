package com.example.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pedidos.model.Orders;
import com.example.pedidos.repository.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository repository;
	
	public List<Orders> AllOrders() {
		return repository.findAll();
	}

}
