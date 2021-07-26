package com.example.model.service.impl;

import com.example.model.entity.User;
import com.example.model.repository.IUserRepository;
import com.example.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }
}
