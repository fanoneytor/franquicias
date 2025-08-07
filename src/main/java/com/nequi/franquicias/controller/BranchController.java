package com.nequi.franquicias.controller;

import com.nequi.franquicias.dto.BranchRequest;
import com.nequi.franquicias.dto.BranchResponse;
import com.nequi.franquicias.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping()
    public ResponseEntity<BranchResponse> addBranchToFranchise(@RequestBody BranchRequest branchRequest) {
        BranchResponse response = branchService.addBranchToFranchise(branchRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchResponse> updateBranchName(@PathVariable Long id, @RequestBody String newName) {
        BranchResponse response = branchService.updateBranchName(id, newName);
        return ResponseEntity.ok(response);
    }

}
