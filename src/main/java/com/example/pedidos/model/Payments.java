package com.example.pedidos.model;

import java.time.LocalDateTime;

import com.example.pedidos.enums.Method;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Setter;

@Entity
@Table(name = "Payments")
@Setter
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, insertable=false, updatable=false)
	private Integer order_id;
	@Enumerated(EnumType.STRING)
	private Method method;
	@Column(nullable = false)
	@Min(0)
	private Integer amount_cents;
	@Column
	private LocalDateTime paid_at;
	@ManyToOne
	private Orders order;
}
