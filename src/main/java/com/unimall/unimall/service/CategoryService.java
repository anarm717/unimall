package com.unimall.unimall.service;

import java.util.List;


import com.unimall.unimall.entity.Category;

public interface CategoryService {
    List<Category> getAll();
    Category add(String categoryName);
}
