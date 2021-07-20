package com.example.model.service;

import com.example.model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer>findAll();
    void save(Customer customer);
    void update(int id , Customer customer);
    Customer findOne(int id);
    void remove(int id);
}
