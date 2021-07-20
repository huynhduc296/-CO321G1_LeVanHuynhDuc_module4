package com.example.model.repository;

import com.example.model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer>findAll();
    void save(Customer customer);
    void update(int id , Customer customer);
    Customer findOne(int id);
    void remove(int id);
}
