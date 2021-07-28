package com.example.model.service;

import com.example.model.entity.Cart;
import com.example.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    void deleteProductInCart(Long id, Cart cart);
}
