package com.example.model.service;

import com.example.model.entity.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    List<User> findAll();
}
