package com.unimall.unimall.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimall.unimall.entity.Category;
import com.unimall.unimall.model.CategoryInputModel;
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
    public Category add(CategoryInputModel categoryInputModel) {
        Category category = new Category();
        category.setName(categoryInputModel.categoryName());
        category.setParentId(categoryInputModel.parentId());
        category.setStatus(1);
      // categoryRepository.findById((long) 1);
       //categoryRepository.delete(category);
        return categoryRepository.save(category);
        
    }
    public String deleteById(Long id){
        
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Category was successfully deleted!"; 
        }else{
            return "Id not found!";
        }
       
    }

  /*   public Category deleteById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            categoryRepository.delete(category);
            return category;
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }*/

   

    public Object updateById(Long id, String newName){
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(newName);
            return categoryRepository.save(category);
        } else {
            return "id not found";
        }
    }

    

 /*   @Override
    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }*/

}
