package com.unimall.unimall.service;

import java.util.List;

import com.unimall.unimall.entity.Product;
import com.unimall.unimall.model.ProductInputModel;

public interface  ProductService {
     static Object addProduct(ProductInputModel productInputModel){
       return  ProductServiceImpl.addProduct(productInputModel);       
     }
     Object deactivateProduct(Long id);
     List<Product> getProducts();
     Object activateProduct(Long id);
     Object deleteProduct(Long id);
     Object updateProduct(String newName, Long id);
    }
