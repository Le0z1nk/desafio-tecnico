package com.example.pedidos.model;

import java.time.LocalDateTime;
import java.util.List;

import com.example.pedidos.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;

@Entity
@Table(name = "Orders")
@Setter
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, insertable = false, updatable = false)
	private Integer customer_id;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Status status;
	@Column(nullable = false)
	private LocalDateTime created_at;
	@ManyToOne
	private Customers customer;
	@OneToMany(mappedBy = "order")
    private List<OrderItems> items;
	@OneToMany(mappedBy = "order")
    private List<Payments> payments;
}
