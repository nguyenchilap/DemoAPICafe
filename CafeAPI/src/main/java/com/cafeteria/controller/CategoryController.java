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

import com.cafeteria.entity.Category;
import com.cafeteria.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/all")
	public List<Category> getAllCategory(){
		return categoryService.categoryList();
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	@DeleteMapping("{id}")
	public String deleteCategory(@PathVariable Integer id) {
		categoryService.deleteById(id);
		return "successfully";
	}
}
