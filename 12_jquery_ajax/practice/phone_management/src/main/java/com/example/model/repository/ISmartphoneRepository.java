package com.example.model.repository;

import com.example.model.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
