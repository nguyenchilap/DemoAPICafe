package com.cafeteria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.entity.Category;
import com.cafeteria.repository.CategoryRepository;
import com.cafeteria.repository.StoreRepository;
import com.cafeteria.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepo;
	private StoreRepository storeRepo;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepo, StoreRepository storeRepo) {
		this.categoryRepo = categoryRepo;
		this.storeRepo = storeRepo;
	}

	@Override
	public List<Category> categoryList() {
		return categoryRepo.findAll();
	}

	@Override
	public Category findById(Integer id) {
		return categoryRepo.findById(id).orElse(null);
	}

	@Override
	public Category addCategory(Category category) {
		category.setStore(storeRepo.findById(category.getStoreId()).orElse(null));
		return categoryRepo.save(category);
	}

	@Override
	public String deleteById(Integer id) {
		categoryRepo.deleteById(id);
		return "Delete successfully";
	}

}
