package com.example.consumer_voice_system.service;

import com.example.consumer_voice_system.entity.Category;
import com.example.consumer_voice_system.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    // Save category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    // Get category by ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
