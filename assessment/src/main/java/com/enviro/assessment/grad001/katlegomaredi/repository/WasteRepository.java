package com.enviro.assessment.grad001.katlegomaredi.repository;

import com.enviro.assessment.grad001.katlegomaredi.models.Waste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WasteRepository extends JpaRepository<Waste, Integer> {
    List<Waste> findByCategory(String category);
}
