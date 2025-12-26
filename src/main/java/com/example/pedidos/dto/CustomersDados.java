package com.example.pedidos.dto;

import java.time.LocalDateTime;

import com.example.pedidos.model.Customers;

public record CustomersDados(String name, String email, LocalDateTime created_at) {

}
