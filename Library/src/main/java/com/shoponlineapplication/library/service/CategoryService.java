package com.shoponlineapplication.library.service;

import com.shoponlineapplication.library.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);

    Category getCategoryById(Long id);
    Category update(Category category);
    void deleteById(Long id);
    void enableById(Long id);
}
