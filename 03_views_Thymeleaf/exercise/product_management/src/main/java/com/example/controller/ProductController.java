package com.example.controller;

import com.example.model.bean.Product;
import com.example.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @RequestMapping(value = "")
    public ModelAndView view() {
        List<Product> productList = productService.findAll();
        return new ModelAndView("/list", "products", productList);
    }


    @GetMapping(value = "/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "product", new Product());
    }



    @PostMapping(value = "/create")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Create Success");
        return "redirect:/product/";
    }



    @GetMapping(value = "/edit")
    public String showFormEdit(@RequestParam int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }



    @PostMapping(value = "/edit")
    public String updateProduct(@ModelAttribute Product product) {
        this.productService.update(product.getId(), product);
        return "redirect:/product/";
    }



    @GetMapping(value = "/delete")
    public String delete(@RequestParam int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "/delete";
    }



    @PostMapping(value = "/delete")
    public String remove(@ModelAttribute Product product) {
        this.productService.remove(product.getId());
        return "redirect:/product/";
    }


    @GetMapping(value = "/view")
    public ModelAndView showInfo(@RequestParam int id) {
        return new ModelAndView("/view", "product", productService.findById(id));
    }



    @PostMapping(value = "/search")
    public ModelAndView search(@RequestParam String search) {
        return new ModelAndView("/list", "products", this.productService.searchByName(search));
    }
}