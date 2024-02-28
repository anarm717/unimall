package com.unimall.unimall.entity;

import com.unimall.unimall.model.ProductInputModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int status;
    @Column
    private double price;
    @Column
    private String category;


    public Product(ProductInputModel productInputModel) {
        this.name = productInputModel.productName();
        this.description=productInputModel.description();
        this.status =1;
        this.price=productInputModel.price();
        this.category=productInputModel.category();
    }
    public Product() {
    }
    
    
    
    
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    





}
