package com.enviro.assessment.grad001.katlegomaredi.service;

import com.enviro.assessment.grad001.katlegomaredi.excepttion.ApiRequestException;
import com.enviro.assessment.grad001.katlegomaredi.models.entities.Category;
import com.enviro.assessment.grad001.katlegomaredi.models.response.Response;
import com.enviro.assessment.grad001.katlegomaredi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
        if (existingCategory!=null) {
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

    public Response deleteCategory(Integer id) {
        if (id == null) {
            throw new ApiRequestException("Category id cannot be null");
        }
        Optional<Category> dbCategory = categoryRepository.findById(id);
        if (!dbCategory.isPresent()) {
            throw new ApiRequestException("Category does not exist, make sure that the category id is correct");
        }
        try {
            categoryRepository.deleteById(id);
            return new Response( "Category deleted successfully");
        } catch (Exception e) {
            throw new ApiRequestException("Cannot delete category");
        }
    }
}
