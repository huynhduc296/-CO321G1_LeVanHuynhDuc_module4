package com.example.model.service;

import com.example.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);
}
