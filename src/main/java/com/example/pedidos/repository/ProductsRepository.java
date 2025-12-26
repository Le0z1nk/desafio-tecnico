package com.example.pedidos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pedidos.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
	
	Optional<Products> findByCategory(String category);
}
