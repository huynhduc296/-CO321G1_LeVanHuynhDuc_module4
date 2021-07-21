package com.example.controller;

import com.example.model.bean.Blog;
import com.example.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "")
    public String goHome(Model model){
        model.addAttribute("blog",blogService.findAll());
        return "home";
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String editBlog(@ModelAttribute Blog blog,Model model){
        this.blogService.save(blog);
        model.addAttribute("blog",blog);
        model.addAttribute("msg","Edit successfully");
        return "edit";
    }

    @GetMapping(value = "/show")
    public String showBlog(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "show";
    }
    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "delete";
    }
    @PostMapping(value = "/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.blogService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete Success");
        return "redirect:/blog";
    }

}
