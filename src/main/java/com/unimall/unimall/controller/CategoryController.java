package com.unimall.unimall.controller;

import org.springframework.web.bind.annotation.RestController;

import com.unimall.unimall.entity.Category;
import com.unimall.unimall.entity.CategoryList;
import com.unimall.unimall.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public List<Category> getAll() {
        List<Category> categoryList= categoryService.getAll();
    return categoryList;
    }
    @PostMapping
    public Category addCategory(@RequestBody String categoryName) {
        return categoryService.add(categoryName);
    }
    @PutMapping("/{id}")
    public void updateById(@PathVariable Integer id, @RequestBody String newName) {
        CategoryList.getAll();
        CategoryList.updateById(id, newName);
        
     
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        CategoryList.getAll();
        CategoryList.deleteById(id);

       

    }
       @PutMapping("deactivate/{id}")
       public void deactivateById(@PathVariable Integer id) {
           CategoryList.getAll();
        CategoryList.deactivateById(id);
           
          
       }
        @PutMapping("activate/{id}")
        public void activateById(@PathVariable Integer id) {
          CategoryList.getAll();
          CategoryList.activateById(id);
            
           
        }
    
}
