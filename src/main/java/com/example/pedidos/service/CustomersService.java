package com.example.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pedidos.dto.CustomersDados;
import com.example.pedidos.model.Customers;
import com.example.pedidos.repository.CustomersRepository;

@Service
public class CustomersService {
	@Autowired
	private CustomersRepository repository;
	
	public List<Customers> allCustomers() {
		return repository.findAll();
	}
	
	public String cadastrar(CustomersDados dados) {
		var cliente = new Customers(dados.id(), dados.name(), dados.email(), dados.created_at());
		repository.save(cliente);
		return "Cadastro de cliente concluido!";
	}
}
