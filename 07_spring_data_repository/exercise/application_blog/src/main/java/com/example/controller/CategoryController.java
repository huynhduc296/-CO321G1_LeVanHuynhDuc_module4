package com.example.controller;

import com.example.model.bean.Category;
import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IBlogService blogService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("category", categoryService.findAll());
        return "/category/list";
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping(value = "/create")
    public String createCategory(@ModelAttribute Category category, Model model) {
        this.categoryService.save(category);
        model.addAttribute("msg", "Create Successfully");
        return "/category/create";
    }

    @GetMapping(value = "/edit")
    public String showFormEdit(@RequestParam long id, Model model) {
        model.addAttribute("category", this.categoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping(value = "edit")
    public String editCategory(@ModelAttribute Category category) {
        this.categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Long id, Model model) {
        model.addAttribute("category", this.categoryService.findById(id));
        return "/category/delete";
    }

    @PostMapping(value = "/delete")
    public String deleteCategory(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        this.categoryService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Delete Success");
        return "redirect:/category";
    }

    @GetMapping(value = "/show")
    public String goHome(@RequestParam Long id, Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("blog", blogService.findAllByCategory_Id(id, pageable));
        return "blog/list";
    }
}