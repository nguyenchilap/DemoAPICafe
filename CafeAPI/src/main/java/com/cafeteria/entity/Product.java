package com.cafeteria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id", unique=true)
	private Integer productId ;
	
	@Column(name="product_name", length=100)
	private String productName ;
	
	@Column(name="product_price")
	private Long productPrice;
	
	
}
