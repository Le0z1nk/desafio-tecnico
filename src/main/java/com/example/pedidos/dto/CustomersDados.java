package com.example.pedidos.dto;

import java.time.LocalDateTime;

public record CustomersDados(Long id, String name, String email, LocalDateTime created_at) {

}
