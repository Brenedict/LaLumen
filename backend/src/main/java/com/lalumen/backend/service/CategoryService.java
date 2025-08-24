package com.lalumen.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lalumen.backend.entity.Category;
import com.lalumen.backend.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(int id) {
        Optional<Category> category = repository.findById(id);

        if(!category.isPresent()) {
            throw new RuntimeException("Category with id " + id + "not found");
        }

        return category.get();
    }

    public Category postCategory(Category category) {
        category.setCategoryId(0);
        return repository.save(category);
    }
}
