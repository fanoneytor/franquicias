package com.nequi.franquicias.service;

import com.nequi.franquicias.dto.FranchiseRequest;
import com.nequi.franquicias.dto.FranchiseResponse;

public interface FranchiseService {
    FranchiseResponse createFranchise(FranchiseRequest franchiseRequest);

    FranchiseResponse updateFranchiseName(Long id, FranchiseRequest newName);
}
