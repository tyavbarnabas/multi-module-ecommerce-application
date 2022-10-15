package com.shoponlineapplication.library.impl;

import com.shoponlineapplication.library.model.Category;
import com.shoponlineapplication.library.repository.CategoryRepository;
import com.shoponlineapplication.library.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private  CategoryRepository repo;

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category save(Category category) {
        try{
            Category categorySave = new Category(category.getName());
            return repo.save(categorySave);

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Category getCategoryById(Long id) {
       return repo.getById(id);

    }

    @Override
    public Category update(Category category) {
        Category categoryUpdate = new Category();
        categoryUpdate.setName(category.getName());
        categoryUpdate.set_activated(category.is_activated());
        categoryUpdate.set_deleted(category.is_deleted());
        return repo.save(categoryUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Category category = repo.getById(id);
        category.set_deleted(true);
        category.set_activated(false);
        repo.save(category);

    }

    @Override
    public void enableById(Long id) {
        Category category = repo.getById(id);
        category.set_activated(true);
        category.set_deleted(false);
        repo.save(category);

    }
}
