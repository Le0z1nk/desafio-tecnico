package com.example.pedidos.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Table(name = "Customers")
@Setter
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private LocalDateTime created_at;
	@OneToMany(mappedBy = "customer")
	private List<Orders> orders;
	
	@PrePersist
    public void prePersist() {
        this.created_at = LocalDateTime.now();
    }
	
	public Customers() {
		
	}
	
	public Customers(Long id, String name, String email, LocalDateTime created_at) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.created_at = created_at;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}
		
}
