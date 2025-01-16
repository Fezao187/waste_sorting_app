package com.enviro.assessment.grad001.katlegomaredi.repository;

import com.enviro.assessment.grad001.katlegomaredi.models.entities.RecyclingTips;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecyclingTipsRepository extends JpaRepository<RecyclingTips, Integer> {
    List<RecyclingTips> findByWasteId(Integer wasteId);
}
