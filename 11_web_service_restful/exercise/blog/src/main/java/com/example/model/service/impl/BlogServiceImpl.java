package com.example.model.service.impl;

import com.example.model.entity.Blog;
import com.example.model.repository.IBlogRepository;
import com.example.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;


    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }


    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }


    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByNameContaining(String name, Pageable pageable) {
        return iBlogRepository.findAllByNameContaining(name,pageable);
    }


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllBlogByCategory(Long category_id) {
        return this.iBlogRepository.findAllBlogByCategory(category_id);
    }

}
