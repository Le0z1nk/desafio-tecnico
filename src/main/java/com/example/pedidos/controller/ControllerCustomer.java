package com.example.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedidos.dto.CustomersDados;
import com.example.pedidos.model.Customers;
import com.example.pedidos.repository.CustomersRepository;
import com.example.pedidos.service.CustomersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class ControllerCustomer {
	@Autowired
	private CustomersService service;
	@Autowired
	private CustomersRepository repository;
	
	
	@GetMapping
	public List<Customers> listarTodosClientes() {
		return service.allCustomers();
	}
	
	@PostMapping
	public ResponseEntity<String> cadastrarCliente(@RequestBody @Valid CustomersDados dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dados));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Customers customer) {
		boolean existe = repository.existsByEmail(customer.getEmail());

	    if (!existe) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }

	    return ResponseEntity.ok().build();
	}
}
