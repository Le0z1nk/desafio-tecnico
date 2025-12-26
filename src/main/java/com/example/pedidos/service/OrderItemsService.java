package com.example.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pedidos.dto.OrderItemsDados;
import com.example.pedidos.model.OrderItems;
import com.example.pedidos.repository.OrderItemsRepository;

@Service
public class OrderItemsService {
	@Autowired
	private OrderItemsRepository repository;
	
//	public List<OrderItems> AllOrderItems() {
//		return repository.findAll();
//	}
	
	public String cadastrar(OrderItemsDados dados) {
		var pedido = new OrderItems(dados.order_id(), dados.product_id(), dados.quantity(), dados.unit_price_cents());
		repository.save(pedido);
		return "Cadastro de pedido com sucesso";
	}
}
