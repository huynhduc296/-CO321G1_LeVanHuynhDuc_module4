package com.example.provincial_management.controller;

import com.example.provincial_management.model.bean.Customer;
import com.example.provincial_management.model.bean.Province;
import com.example.provincial_management.model.service.ICustomerService;
import com.example.provincial_management.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
@Controller
public class CustomerController {

        @Autowired
        private ICustomerService iCustomerService;
    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }


    @GetMapping("/create-customer")
        public ModelAndView showCreateForm() {
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", new Customer());
            return modelAndView;
        }

        @PostMapping("/create-customer")
        public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
            iCustomerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }

        @GetMapping("/customers")
        public ModelAndView listCustomers(Pageable pageable){
            Page<Customer> customers = iCustomerService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/customer/list");
            modelAndView.addObject("customers", customers);
            return modelAndView;
        }
    @GetMapping("/customers")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = iCustomerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers = iCustomerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

        @GetMapping("/edit-customer/{id}")
        public ModelAndView showEditForm(@PathVariable Long id) {
            Optional<Customer> customer = iCustomerService.findById(id);
            if (customer.isPresent()) {
                ModelAndView modelAndView = new ModelAndView("/customer/edit");
                modelAndView.addObject("customer", customer.get());
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("error");
                return modelAndView;
            }
        }

        @PostMapping("/edit-customer")
        public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
            iCustomerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", "Customer updated successfully");
            return modelAndView;
        }

        @GetMapping("/delete-customer/{id}")
        public ModelAndView showDeleteForm(@PathVariable Long id) {
            Optional<Customer> customer = iCustomerService.findById(id);
            if (customer.isPresent()) {
                ModelAndView modelAndView = new ModelAndView("/customer/delete");
                modelAndView.addObject("customer", customer.get());
                return modelAndView;

            } else {
                ModelAndView modelAndView = new ModelAndView("error");
                return modelAndView;
            }
        }

        @PostMapping("/delete-customer")
        public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
            iCustomerService.remove(customer.getId());
            return "redirect:customers";
        }
    }
