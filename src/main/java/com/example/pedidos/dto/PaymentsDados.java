package com.example.pedidos.dto;

import java.time.LocalDateTime;

import com.example.pedidos.enums.Method;

public record PaymentsDados(Integer order_id, Method method, Integer amount_cents, LocalDateTime paid_at) {

}
