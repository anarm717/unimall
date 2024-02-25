package com.unimall.unimall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimall.unimall.entity.Product;
import com.unimall.unimall.model.ProductInputModel;
import com.unimall.unimall.service.ProductService;


@RestController
@RequestMapping("/product")


public class ProductController {
    
    @Autowired 
    ProductService productService;


    @GetMapping()
    public List<Product> getProducts(){
        List<Product> productsList = productService.getProducts();
        return productsList;
    }
    @PostMapping()
    public static Object addProduct(@RequestBody ProductInputModel productInputModel){
        ProductService.addProduct(productInputModel);
        return "Product was successfully added!";
    }

    @PutMapping()
    public Object activateProduct(@PathVariable Long id){
        return productService.activateProduct(id);
    }
    @PutMapping()
    public Object deactivateProduct(@PathVariable Long id){
        return productService.deactivateProduct(id);
    }
    @DeleteMapping()
    public Object deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
    @PutMapping()
    public Object updateProduct(@PathVariable Long id, @RequestBody String newName){
        return productService.updateProduct(newName, id);
    }

}
