package com.example.controller;

import com.example.model.bean.Blog;
import com.example.model.bean.Category;
import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;
    @GetMapping
    public ModelAndView listBlog(@RequestParam("search")Optional<String> search,
    @PageableDefault(size = 2)
    @SortDefault(sort = "date",direction = Sort.Direction.DESC) Pageable pageable){
        Page<Blog> blogs;
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        if(search.isPresent()){
            blogs = blogService.findAllByNameContaining(search.get(), pageable);
            modelAndView.addObject("search",search.get());
        } else {
            blogs = blogService.findAll(pageable);
        }
        modelAndView.addObject("blog", blogs);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",categoryService.findAll());
        return "/blog/create";
    }

    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        blog.setDate(new Date(System.currentTimeMillis()));
        return "redirect:/blog";
    }
    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        model.addAttribute("category",categoryService.findAll());
        return "/blog/edit";
    }
    @PostMapping(value = "/edit")
    public String editBlog(@ModelAttribute Blog blog,Model model){
        this.blogService.save(blog);
        model.addAttribute("blog",blog);
        model.addAttribute("msg","Edit successfully");
        return "/blog/edit";
    }

    @GetMapping(value = "/show")
    public String showBlog(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "/blog/show";
    }

    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping(value = "/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.blogService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete Success");
        return "redirect:/blog";
    }

}