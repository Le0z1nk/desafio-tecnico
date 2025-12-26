package com.example.pedidos.dto;

import java.time.LocalDateTime;

import com.example.pedidos.enums.Status;

public record OrdersDados(Integer customer_id, Status status, LocalDateTime created_at) {

}
