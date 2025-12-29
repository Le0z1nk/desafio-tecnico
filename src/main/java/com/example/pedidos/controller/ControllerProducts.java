package com.example.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedidos.dto.ProductsDados;
import com.example.pedidos.model.Products;
import com.example.pedidos.service.ProductsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ControllerProducts {
	@Autowired
	private ProductsService service;
	
	@GetMapping
	public List<Products> listarTodosProdutos() {
		return service.allProducts();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Products>> listarPorCategoria(@PathVariable String category){
		List<Products> product = service.findByCategory(category);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Products>> listarPorNome(@PathVariable String name) {
		List<Products> productName = service.findByName(name);
		return ResponseEntity.ok(productName);
	}
	
	@PostMapping
	public ResponseEntity<String> cadastrarProduto(@RequestBody @Valid ProductsDados dados) {
	    return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dados));
	}
}
