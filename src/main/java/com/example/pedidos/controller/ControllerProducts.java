package com.example.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedidos.model.Products;
import com.example.pedidos.repository.ProductsRepository;
import com.example.pedidos.service.ProductsService;

@RestController
@RequestMapping("/product")
public class ControllerProducts {
	@Autowired
	private ProductsService service;
	
	@Autowired
	private ProductsRepository repository;
	
	private Products product;
	
	@GetMapping
	public List<Products> listarTodosProdutos() {
		return service.allProducts();
	}
	
	@GetMapping("/{category}")
	public ResponseEntity<Products> listarPorCategoria(@PathVariable String category){
		product = service.findByCategory(category);
		return ResponseEntity.ok(product);
	}
}
