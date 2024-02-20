package com.unimall.unimall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimall.unimall.entity.Category;
import com.unimall.unimall.repository.CategoryRepository;
@Service
public class CategoryServiceImp implements CategoryService{
   
    @Autowired
    private CategoryRepository categoryRepository;
   
    @Override
    public List<Category> getAll() {
        List<Category> categoryList= categoryRepository.getAll();
        return  categoryList;
    }

    @Override
    public Category add(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(0);
        category.setStatus(0);
      // categoryRepository.findById((long) 1);
       // categoryRepository.delete(category);
        return categoryRepository.save(category);
        
    }
    



}
