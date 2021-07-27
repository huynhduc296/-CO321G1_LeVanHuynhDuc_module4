package com.example.model.repository;

import com.example.model.entity.Borrow;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BorrowRepository extends PagingAndSortingRepository<Borrow,Long> {
}
