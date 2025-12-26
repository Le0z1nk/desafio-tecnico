package com.example.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pedidos.model.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long>{
	
}
