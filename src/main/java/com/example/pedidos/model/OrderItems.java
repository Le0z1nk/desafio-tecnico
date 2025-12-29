package com.example.pedidos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Order_Items")
public class OrderItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, insertable=false, updatable=false)
	private Integer order_id;
	@Column(nullable = false, insertable=false, updatable=false)
	private Integer product_id;
	@Column(nullable = false)
	@Positive
	private Integer quantity;
	@Column(nullable = false)
	@Min(0)
	private Integer unit_price_cents;
	@ManyToOne
	private Orders order;
	@ManyToOne
	private Products product;
	
	public OrderItems(Integer order_id, Integer product_id, Integer quantity, Integer unit_price_cents) {
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.unit_price_cents = unit_price_cents;
	}

}
