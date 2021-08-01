package com.example.controller;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/blogs")
public class BlogRestController {

    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping(value = "/category")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        List<Category> categoryList = (List<Category>) this.categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping(value = "/blog-of-category/{id}")
    public ResponseEntity<List<Blog>> findAllBlogByCategory(@PathVariable Long id){
        List<Blog> blogList = this.blogService.findAllBlogByCategory(id);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id){
        Blog blog = this.blogService.findById(id).orElse(null);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping(value = "/search/{name}")
    public ResponseEntity<List<Blog>> findBlogByName(@PathVariable String name){
        List<Blog> blogList = this.blogService.findBlogByName(name);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<Page<Blog>> goListBlog(@RequestParam int page,
     @RequestParam Optional<String> name) {
        String names="";
        if(name.isPresent()){
            names=name.get();
        }
        Page<Blog> blogs = this.blogService.findAllByName(PageRequest.of(page,3), names);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}