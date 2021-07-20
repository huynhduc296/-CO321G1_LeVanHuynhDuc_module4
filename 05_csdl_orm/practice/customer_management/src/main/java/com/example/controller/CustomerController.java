package com.example.controller;

import com.example.model.bean.Customer;
import com.example.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping(value = "/customer")
@Controller
public class CustomerController {

    // Singleton
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customer", customers);
        return modelAndView;
    }

    @GetMapping(value = "/edit")
    public String showFormEdit(@RequestParam int id, Model model) {
        Customer customer = this.customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "/edit";
    }

    @PostMapping(value = "/edit")
    public String updateProduct(@ModelAttribute Customer customer) {
        this.customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping(value = "/create")
    public String goCreateNewStudent(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg",
                "Create new successfully!");

        return "redirect:/customer";
    }
}
