package com.cafeteria.service;

import java.util.List;

import com.cafeteria.entity.Category;

public interface CategoryService {
	List<Category> categoryList();
	
	Category findById(Integer id);
	
	Category addCategory(Category category);
	
	String deleteById(Integer id);
}
