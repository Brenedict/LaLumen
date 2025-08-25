package com.lalumen.backend.controller;

import com.lalumen.backend.entity.Category;
import com.lalumen.backend.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping
    public List<Category> getCategories() {
        return service.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return service.getCategoryById(id);
    }

    @PostMapping
    public Category postCategory(@RequestBody Category category) {
        return service.postCategory(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
