package com.example.model.service;

import com.example.model.entity.Borrow;

import java.util.Optional;

public interface BorrowService {
    Iterable<Borrow> findAll();

    Optional<Borrow> findById(Long id);

    void save(Borrow borrow);

    void remove(Long id);
}
