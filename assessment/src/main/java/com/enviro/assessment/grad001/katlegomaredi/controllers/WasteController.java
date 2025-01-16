package com.enviro.assessment.grad001.katlegomaredi.controllers;

import com.enviro.assessment.grad001.katlegomaredi.models.entities.Category;
import com.enviro.assessment.grad001.katlegomaredi.models.entities.Waste;
import com.enviro.assessment.grad001.katlegomaredi.models.response.Response;
import com.enviro.assessment.grad001.katlegomaredi.service.WasteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste")
public class WasteController {
    private final WasteService wasteService;

    public WasteController(WasteService wasteService) {
        this.wasteService = wasteService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Waste>> getAll() {
        return new ResponseEntity<>(wasteService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Waste> createWaste(@RequestBody Waste waste) {
        return new ResponseEntity<>(wasteService.createWaste(waste), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Waste> getWasteById(@PathVariable Integer id) {
        return new ResponseEntity<>(wasteService.findWasteById(id), HttpStatus.OK);
    }

    @GetMapping("/get/byCategory")
    public ResponseEntity<List<Waste>> getWasteByCategory(@RequestBody Category category) {
        return new ResponseEntity<>(wasteService.getWasteByCategoryName(category), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Waste> updateWaste(@PathVariable Integer id, @RequestBody Waste waste) {
        return new ResponseEntity<>(wasteService.updateWaste(id, waste), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteWaste(@PathVariable Integer id) {
        return new ResponseEntity<>(wasteService.deleteWaste(id), HttpStatus.OK);
    }
}

