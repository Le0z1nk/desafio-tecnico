package com.example.pedidos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pedidos.model.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
	boolean existsByEmail(String email);
}
