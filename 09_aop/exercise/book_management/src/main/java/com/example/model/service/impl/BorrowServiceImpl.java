package com.example.model.service.impl;

import com.example.model.entity.Borrow;
import com.example.model.repository.BorrowRepository;
import com.example.model.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BorrowRepository borrowRepository;

    @Override
    public Iterable<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return borrowRepository.findById(id);
    }

    @Override
    public void save(Borrow borrow) {
        this.borrowRepository.save(borrow);
    }

    @Override
    public void remove(Long id) {
        this.borrowRepository.deleteById(id);
    }
}
