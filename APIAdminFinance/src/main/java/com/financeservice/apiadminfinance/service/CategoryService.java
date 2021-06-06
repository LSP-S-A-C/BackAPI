package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long categoryId);
    void delete(Long categoryId) ;
    List<Category> findAll();
    Category save(Category categoryId);
}
