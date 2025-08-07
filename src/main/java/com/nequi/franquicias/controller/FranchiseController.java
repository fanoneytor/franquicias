package com.nequi.franquicias.controller;

import com.nequi.franquicias.dto.FranchiseRequest;
import com.nequi.franquicias.dto.FranchiseResponse;
import com.nequi.franquicias.service.FranchiseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @PostMapping
    public ResponseEntity<FranchiseResponse> createFranchise(@RequestBody FranchiseRequest franchiseRequest) {
        FranchiseResponse response = franchiseService.createFranchise(franchiseRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FranchiseResponse> updateFranchiseName(@PathVariable Long id, @RequestBody FranchiseRequest newName) {
        FranchiseResponse response = franchiseService.updateFranchiseName(id, newName);
        return ResponseEntity.ok(response);
    }
}
