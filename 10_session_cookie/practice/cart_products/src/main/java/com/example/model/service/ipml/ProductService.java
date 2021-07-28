package com.example.model.service.ipml;

import com.example.model.entity.Product;
import com.example.model.repository.IProductRepository;
import com.example.model.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
