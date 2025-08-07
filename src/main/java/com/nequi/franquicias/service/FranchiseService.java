package com.nequi.franquicias.service;

import com.nequi.franquicias.controller.dto.FranchiseRequest;
import com.nequi.franquicias.controller.dto.FranchiseResponse;

public interface FranchiseService {
    FranchiseResponse createFranchise(FranchiseRequest franchiseRequest);
    FranchiseResponse updateFranchiseName(Long id, String newName);
}
