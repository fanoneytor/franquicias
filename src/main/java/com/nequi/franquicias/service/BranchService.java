package com.nequi.franquicias.service;

import com.nequi.franquicias.dto.BranchRequest;
import com.nequi.franquicias.dto.BranchResponse;

public interface BranchService {
    BranchResponse addBranchToFranchise(BranchRequest branchRequest);

    BranchResponse updateBranchName(Long branchId, String newName);
}
