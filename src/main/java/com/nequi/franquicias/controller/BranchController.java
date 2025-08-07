package com.nequi.franquicias.controller;

import com.nequi.franquicias.controller.dto.BranchRequest;
import com.nequi.franquicias.controller.dto.BranchResponse;
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

    @PostMapping("/franchise/{franchiseId}")
    public ResponseEntity<BranchResponse> createBranch(@PathVariable Long franchiseId, @RequestBody BranchRequest branchRequest) {
        BranchResponse response = branchService.createBranch(franchiseId, branchRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchResponse> updateBranchName(@PathVariable Long id, @RequestBody String newName) {
        BranchResponse response = branchService.updateBranchName(id, newName);
        return ResponseEntity.ok(response);
    }

}
