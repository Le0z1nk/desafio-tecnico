package com.example.pedidos.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "Products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	@Min(0)
	private Integer price_cents;
	@Column(nullable = false)
	private Boolean active = true;
	@OneToMany(mappedBy = "product")
    private List<OrderItems> items;
	
	public Products() {
		
	}
	
	public Products(Long id, String name, String category, Integer price_cents, Boolean active) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price_cents = price_cents;
		this.active = active;
	}

	public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getActive() {
        return active;
    }

    public Integer getPriceCents() {
        return price_cents;
    }
}
	

