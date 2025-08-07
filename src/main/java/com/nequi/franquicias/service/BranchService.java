package com.nequi.franquicias.service;

import com.nequi.franquicias.controller.dto.BranchRequest;
import com.nequi.franquicias.controller.dto.BranchResponse;

public interface BranchService {
    BranchResponse createBranch(Long franchiseId, BranchRequest branchRequest);

    BranchResponse updateBranchName(Long branchId, String newName);
}
