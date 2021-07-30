package com.example.model.repository;

import com.example.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);

    @Query(value = "select * from blog where category_id = ?1",nativeQuery = true)
    List<Blog> findAllBlogByCategory(Long category_id);

    @Query(value = "select  * from blog where name like %?1%",nativeQuery = true)
    List<Blog> findBlogByName(String name);

    @Query(value="select * from blog where `name` like :name",nativeQuery=true)
    Page<Blog>findAllByName(Pageable pageable, @Param("name") String name);
}
