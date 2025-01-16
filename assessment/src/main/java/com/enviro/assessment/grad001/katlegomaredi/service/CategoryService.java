package com.enviro.assessment.grad001.katlegomaredi.service;

import com.enviro.assessment.grad001.katlegomaredi.excepttion.ApiRequestException;
import com.enviro.assessment.grad001.katlegomaredi.models.Category;
import com.enviro.assessment.grad001.katlegomaredi.repository.CategoryRepository;
import com.enviro.assessment.grad001.katlegomaredi.repository.WasteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final WasteRepository wasteRepository;

    public CategoryService(CategoryRepository categoryRepository, WasteRepository wasteRepository) {
        this.categoryRepository = categoryRepository;
        this.wasteRepository = wasteRepository;
    }

    public List<Category> findAll() {
        try {
            List<Category> categories = categoryRepository.findAll();
            return categories;
        } catch (Exception e) {
            throw new ApiRequestException("Cannot find all categories");
        }
    }

    public Category createCategory(Category category) {
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new ApiRequestException("Category name cannot be empty");
        }
        Category existingCategory = categoryRepository.findByName(category.getName());
        if (existingCategory != null) {
            throw new ApiRequestException("Category already exists");
        }
        try {
            Category result = categoryRepository.save(category);
            return result;
        } catch (Exception e) {
            throw new ApiRequestException("Cannot create category");
        }
    }

    public Category getCategoryById(Integer id) {
        if (id == null) {
            throw new ApiRequestException("Category id cannot be null");
        }
        try {
            Category dbCategory = categoryRepository.findById(id).orElseThrow();
            if (dbCategory == null) {
                throw new ApiRequestException("Category does not exist, make sure that the category id is correct");
            }
            return dbCategory;
        } catch (Exception e) {
            throw new ApiRequestException("Cannot find category");
        }
    }

    public Category getCategoryByName(Category request) {
        if (request.getName() == null) {
            throw new ApiRequestException("Category name cannot be null");
        }
        try {
            Category dbCategory = categoryRepository.findByName(request.getName());
            if (dbCategory == null) {
                throw new ApiRequestException("Category does not exist, make sure that the category name is correct");
            }
            return dbCategory;
        } catch (Exception e) {
            throw new ApiRequestException("Cannot find category");
        }
    }

    public Category updateCategory(Integer id, Category category) {
        if (id == null) {
            throw new ApiRequestException("Category id cannot be null");
        }
        if (category.getName() == null) {
            throw new ApiRequestException("Please fill in the category name");
        }
        Category dbCategory = categoryRepository.findById(id).orElseThrow();
        if (dbCategory == null) {
            throw new ApiRequestException("Category does not exist, make sure that the category id is correct");
        }
        try {
            dbCategory.setName(category.getName());
            categoryRepository.save(dbCategory);
            return dbCategory;
        } catch (Exception e) {
            throw new ApiRequestException("Cannot update category");
        }
    }

    public Category deleteCategory(Integer id) {
        if (id == null) {
            throw new ApiRequestException("Category id cannot be null");
        }
        Category dbCategory = categoryRepository.findById(id).get();
        Category deletedCategory = dbCategory;
        if (dbCategory == null) {
            throw new ApiRequestException("Category does not exist, make sure that the category id is correct");
        }
        try {
             categoryRepository.delete(dbCategory);
            return deletedCategory;
        } catch (Exception e) {
            throw new ApiRequestException("Cannot delete category");
        }


    }
}
