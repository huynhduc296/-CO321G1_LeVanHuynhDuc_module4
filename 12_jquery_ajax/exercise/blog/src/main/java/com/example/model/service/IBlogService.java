package com.example.model.service;

import com.example.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);;

    List<Blog> findAllBlogByCategory(Long category_id);

    List<Blog> findBlogByName(String name);

    Page<Blog>findAllByName(Pageable pageable, @Param("name") String name);
}
