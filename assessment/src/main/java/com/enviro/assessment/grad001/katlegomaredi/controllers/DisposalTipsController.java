package com.enviro.assessment.grad001.katlegomaredi.controllers;

import com.enviro.assessment.grad001.katlegomaredi.models.entities.DisposalTips;
import com.enviro.assessment.grad001.katlegomaredi.models.response.Response;
import com.enviro.assessment.grad001.katlegomaredi.service.DisposalTipsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposalTip")
public class DisposalTipsController {
    private final DisposalTipsService disposalTipsService;

    public DisposalTipsController(DisposalTipsService disposalTipsService) {
        this.disposalTipsService = disposalTipsService;
    }

    @PostMapping("/create")
    public ResponseEntity<DisposalTips> createDisposalTips(@RequestBody DisposalTips disposalTips) {
        return new ResponseEntity<>(disposalTipsService.saveDisposalTips(disposalTips), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<DisposalTips>> getAllDisposalTips() {
        return new ResponseEntity<>(disposalTipsService.getAllDisposalTips(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DisposalTips> getDisposalTipById(@PathVariable Integer id) {
        return new ResponseEntity<>(disposalTipsService.getDisposalTipById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DisposalTips> updateDisposalTips(@PathVariable Integer id, @RequestBody DisposalTips disposalTips) {
        return new ResponseEntity<>(disposalTipsService.updateDisposalTips(id, disposalTips), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDisposalTipById(@PathVariable Integer id) {
        return new ResponseEntity<>(disposalTipsService.deleteDisposalTips(id), HttpStatus.OK);
    }
}
