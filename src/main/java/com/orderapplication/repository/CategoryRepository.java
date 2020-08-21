package com.orderapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderapplication.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByCategoryId(Integer id);
}
