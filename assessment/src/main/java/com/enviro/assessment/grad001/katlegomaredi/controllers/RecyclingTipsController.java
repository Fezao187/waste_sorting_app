package com.enviro.assessment.grad001.katlegomaredi.controllers;

import com.enviro.assessment.grad001.katlegomaredi.models.entities.RecyclingTips;
import com.enviro.assessment.grad001.katlegomaredi.models.response.Response;
import com.enviro.assessment.grad001.katlegomaredi.service.RecyclingTipsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recyclingTip")
public class RecyclingTipsController {
    private final RecyclingTipsService recyclingTipsService;

    public RecyclingTipsController(RecyclingTipsService recyclingTipsService) {
        this.recyclingTipsService = recyclingTipsService;
    }

    @PostMapping("/create")
    public ResponseEntity<RecyclingTips> createRecyclingTips(@RequestBody RecyclingTips recyclingTips) {
        return new ResponseEntity<>(recyclingTipsService.addRecyclingTip(recyclingTips), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<RecyclingTips>> getAllRecyclingTips() {
        return new ResponseEntity<>(recyclingTipsService.getAllRecyclingTips(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RecyclingTips> getRecyclingTipById(@PathVariable Integer id) {
        return new ResponseEntity<>(recyclingTipsService.getRecyclingTipById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RecyclingTips> updateRecyclingTip(
            @PathVariable Integer id,
            @RequestBody RecyclingTips recyclingTips) {
        return new ResponseEntity<>(recyclingTipsService.updateRecyclingTip(id, recyclingTips), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRecyclingTip(@PathVariable Integer id) {
        return new ResponseEntity<>(recyclingTipsService.deleteRecyclingTip(id), HttpStatus.OK);
    }
}