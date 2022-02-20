package com.cafeteria.service;

import java.util.List;

import com.cafeteria.entity.Store;

public interface StoreService {
	List<Store> storeList();
	
	Store findById(Integer id);
	
	Store addStore(Store store);
	
	String deleteById(Integer id);
}
