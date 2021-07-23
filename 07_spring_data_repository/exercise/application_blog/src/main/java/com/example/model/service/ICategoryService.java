package com.example.model.service;

import com.example.model.bean.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);

}