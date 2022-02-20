package com.cafeteria.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="store")
public class Store{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="store_id", unique=true)
	private Integer storeId;
	
	@Column(name="store_name", length=100)
	private String storeName;

	@OneToMany(targetEntity=Category.class, mappedBy="store", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Category> categories;
	
	public Store() {
		
	};
	
	public Store(Integer storeId, @JsonProperty("storeName") String storeName, Set<Category> categories) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.categories = categories;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}
