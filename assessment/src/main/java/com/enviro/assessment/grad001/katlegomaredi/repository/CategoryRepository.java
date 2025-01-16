package com.enviro.assessment.grad001.katlegomaredi.repository;

import com.enviro.assessment.grad001.katlegomaredi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryName(String categoryName);
}
