package com.example.pedidos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pedidos.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
	
	List<Products> findByCategory(String category);
	
	List<Products> findByName(String name);
}
