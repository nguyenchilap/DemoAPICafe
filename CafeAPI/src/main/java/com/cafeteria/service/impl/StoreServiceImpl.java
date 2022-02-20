package com.cafeteria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.entity.Store;
import com.cafeteria.repository.StoreRepository;
import com.cafeteria.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{
	
	private StoreRepository storeRepo;
	
	@Autowired
	public StoreServiceImpl(StoreRepository userRepo) {
		this.storeRepo = userRepo;
	}

	@Override
	public List<Store> storeList() {
		return storeRepo.findAll();
	}

	@Override
	public Store findById(Integer id) {
		return storeRepo.findById(id).orElse(null);
	}

	@Override
	public Store addStore(Store store) {
		return storeRepo.save(store);
	}

	@Override
	public String deleteById(Integer id) {
		storeRepo.deleteById(id);
		return "{'message':'Delete successfully'}";
	}

}
