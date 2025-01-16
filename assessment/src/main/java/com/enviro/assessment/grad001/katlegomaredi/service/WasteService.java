package com.enviro.assessment.grad001.katlegomaredi.service;

import com.enviro.assessment.grad001.katlegomaredi.excepttion.ApiRequestException;
import com.enviro.assessment.grad001.katlegomaredi.models.entities.Category;
import com.enviro.assessment.grad001.katlegomaredi.models.entities.Waste;
import com.enviro.assessment.grad001.katlegomaredi.models.response.Response;
import com.enviro.assessment.grad001.katlegomaredi.repository.CategoryRepository;
import com.enviro.assessment.grad001.katlegomaredi.repository.WasteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteService {
    private final WasteRepository wasteRepository;
    private final CategoryRepository categoryRepository;

    public WasteService(WasteRepository wasteRepository, CategoryRepository categoryRepository) {
        this.wasteRepository = wasteRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Waste> findAll() {
        try{
            List<Waste> waste = wasteRepository.findAll();
            return waste;
        }catch (Exception e){
            throw new ApiRequestException("Cannot all records of waste");
        }
    }

    public Waste createWaste(Waste waste) {
        if(waste.getName() == null || waste.getName().isEmpty()) {
            throw new ApiRequestException("Waste name cannot be empty");
        }
        if(waste.getCategory() == null) {
            throw new ApiRequestException("Waste category cannot be empty");
        }
        Waste result = new Waste();
        Category category = categoryRepository.findByName(waste.getCategory().getName());

        try{
            result.setName(waste.getName());
            result.setCategory(category);
            wasteRepository.save(result);
            return result;
        }catch (Exception e){
            throw new ApiRequestException(e.getCause().getMessage());
        }
    }

    public Waste findWasteById(Integer id) {
        if(id == null) {
            throw new ApiRequestException("Waste id cannot be null");
        }
        try{
            Waste waste = wasteRepository.findById(id).orElseThrow();
            if(waste == null) {
                throw new ApiRequestException("Waste not found, make sure waste Id is correct");
            }
            return waste;
        }catch (Exception e){
            throw new ApiRequestException("Cannot find waste");
        }
    }

    public List<Waste> getWasteByCategoryName(Category category) {
        if(category.getName() == null || category.getName().isEmpty()) {
            throw new ApiRequestException("Category name cannot be empty");
        }
        try{
            List<Waste> waste = wasteRepository.findByCategoryName(category.getName());
            if(waste == null) {
                throw new ApiRequestException("Waste not found, make sure you spelled the category name correctly");
            }
            return waste;
        }catch (Exception e){
            throw new ApiRequestException("Cannot find waste");
        }
    }

    public Waste updateWaste(Integer id, Waste waste) {
        if(id == null) {
            throw new ApiRequestException("Waste id cannot be null");
        }
        if(waste.getName() == null || waste.getName().isEmpty()) {
            throw new ApiRequestException("Waste name cannot be empty");
        }
        Waste result = wasteRepository.findById(id).orElseThrow();
        if(waste == null) {
            throw new ApiRequestException("Waste not found, make sure waste Id is correct");
        }
        try{
            result.setName(waste.getName());
            if(waste.getCategory() != null) {
                result.setCategory(waste.getCategory());
            }
            wasteRepository.save(result);
            return result;
        }catch (Exception e){
            throw new ApiRequestException("Cannot update waste");
        }
    }

    public Response deleteWaste(Integer id) {
        if(id == null) {
            throw new ApiRequestException("Waste id cannot be null");
        }
        Optional<Waste> waste = wasteRepository.findById(id);
        if(!waste.isPresent()) {
            throw new ApiRequestException("Waste not found, make sure waste Id is correct");
        }
        try{
            wasteRepository.deleteById(id);
            return new Response("Waste deleted successfully");
        }catch (Exception e){
            throw new ApiRequestException("Cannot delete waste");
        }
    }
}