package com.example.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pedidos.model.Products;
import com.example.pedidos.model.exception.ModelException;
import com.example.pedidos.repository.ProductsRepository;

@Service
public class ProductsService {
	private static final String regex = ".*[^a-zA-ZÀ-ÿ\\s].*";
	
	@Autowired
	private ProductsRepository repository;
	
	public List<Products> allProducts() {
		return repository.findAll();
	}
	
	public Products findByCategory(String category) {
		validarCategoria(category);
		return repository.findByCategory(category).orElseThrow(() -> new ModelException("Categoria não encontrado"));
		
	}
	
	private void validarCategoria(String category) {
		if (category.matches(regex)) {
			throw new ModelException("Categoria inválida. Não pode digitar numeros ou simbolos");
		}
	}
	
}
