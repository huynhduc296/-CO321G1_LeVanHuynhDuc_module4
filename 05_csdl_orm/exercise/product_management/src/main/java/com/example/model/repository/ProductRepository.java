package com.example.model.repository;

import com.example.model.bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product>searchByName(String name);

}
