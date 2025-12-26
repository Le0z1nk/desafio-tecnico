package com.example.pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedidos.repository.PaymentsRepository;
import com.example.pedidos.service.PaymentsService;

@RestController
public class ControllerPayments {
	@Autowired
	private PaymentsService service;
	@Autowired
	private PaymentsRepository repository;
}
