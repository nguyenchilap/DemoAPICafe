package com.cafeteria.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id", unique=true)
	private Integer categoryId ;
	
	@Column(name="category_name", length=100)
	private String categoryName ;

	private transient Integer storeId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="store_id")
	private Store store;
	
	@OneToMany(targetEntity=Product.class, mappedBy="category", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Set<Product> products;
	
	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	public Category() {
		
	}

	public Category(Integer categoryId,  @JsonProperty("categoryName") String categoryName,
			 @JsonProperty("storeId") Integer storeId) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.storeId = storeId;
	}
	
	
}
