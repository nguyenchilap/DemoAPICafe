package com.cafeteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafeteria.entity.Store;
import com.cafeteria.service.StoreService;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
	private StoreService storeService;

	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@GetMapping("/all")
	public List<Store> getAllStore(){
		return storeService.storeList();
	}
	
	@GetMapping("/{id}")
	public Store getStoreById(@PathVariable("id") Integer id) {
		return storeService.findById(id);
	}
	
	@PostMapping
	public Store createStore(@RequestBody Store store) {
		return storeService.addStore(store);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStore(@PathVariable("id") Integer id) {
		return storeService.deleteById(id);
	}
}
