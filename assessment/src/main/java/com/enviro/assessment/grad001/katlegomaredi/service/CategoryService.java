package com.enviro.assessment.grad001.katlegomaredi.service;

import com.enviro.assessment.grad001.katlegomaredi.repository.CategoryRepository;
import com.enviro.assessment.grad001.katlegomaredi.repository.WasteRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final WasteRepository wasteRepository;

    public CategoryService(CategoryRepository categoryRepository, WasteRepository wasteRepository) {
        this.categoryRepository = categoryRepository;
        this.wasteRepository = wasteRepository;
    }


}
