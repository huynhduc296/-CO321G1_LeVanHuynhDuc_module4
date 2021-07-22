package com.example.controller;

import com.example.model.bean.Category;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public String showList(Model model){
        model.addAttribute("category",categoryService.findAll());
        return "/category/list";
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("category",new Category());
        return "/category/create";
    }
    @PostMapping(value = "/create")
    public String createCategory(@ModelAttribute Category category, Model model){
        this.categoryService.save(category);
        model.addAttribute("msg","Create Successfully");
        return "/category/create";
    }

    @GetMapping(value = "/edit")
    public String showFormEdit(@RequestParam long id, Model model){
        model.addAttribute("category",this.categoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping(value = "edit")
    public String editCategory(@ModelAttribute Category category){
        this.categoryService.save(category);
        return "redirect:/category";
    }
}