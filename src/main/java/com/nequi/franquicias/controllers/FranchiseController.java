package com.nequi.franquicias.controllers;

import com.nequi.franquicias.application.CreateFranchiseService;
import com.nequi.franquicias.controllers.dto.FranchiseRequest;
import com.nequi.franquicias.controllers.dto.FranchiseResponse;
import com.nequi.franquicias.domain.model.Franchise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/franchises")
@RequiredArgsConstructor
public class FranchiseController {

    private final CreateFranchiseService createFranchiseService;

    @PostMapping
    public ResponseEntity<FranchiseResponse> createFranchise(@RequestBody FranchiseRequest request) {
        Franchise saved = createFranchiseService.create(request.getName());

        FranchiseResponse response = new FranchiseResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());

        return ResponseEntity.ok(response);
    }
}
