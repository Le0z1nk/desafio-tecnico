package com.example.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pedidos.repository.PaymentsRepository;

@Service
public class PaymentsService {
	@Autowired
	private PaymentsRepository repository;
	
	
}
