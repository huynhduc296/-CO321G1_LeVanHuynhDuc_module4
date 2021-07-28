package com.example.model.service.impl;

import com.example.model.entity.Cart;
import com.example.model.entity.Product;
import com.example.model.repository.ProductRepository;
import com.example.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProductInCart(Long id, Cart cart) {
        cart.getProducts().remove(findById(id));
    }
}
