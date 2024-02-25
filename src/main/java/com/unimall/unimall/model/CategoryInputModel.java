package com.unimall.unimall.model;

public record CategoryInputModel (String categoryName, Long parentId, Long id) {
    // public CategoryInputModel(String categoryName, Long parentId) {
    //    this(categoryName, parentId, null);
    //  }
    

}
