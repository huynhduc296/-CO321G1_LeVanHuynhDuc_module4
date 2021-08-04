package com.example.model.repository;

import com.example.model.entity.AppUser;
import com.example.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole>findByAppUser(AppUser appUser);
}
