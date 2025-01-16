package com.enviro.assessment.grad001.katlegomaredi.repository;

import com.enviro.assessment.grad001.katlegomaredi.models.DisposalTips;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisposalTipsRepository extends JpaRepository<DisposalTips, Integer> {
    List<DisposalTips> findByWasteId(Integer wasteId);
}
