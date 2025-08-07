package com.nequi.franquicias.service;

import com.nequi.franquicias.dto.BranchRequest;
import com.nequi.franquicias.dto.BranchResponse;
import com.nequi.franquicias.mapper.BranchMapper;
import com.nequi.franquicias.model.Branch;
import com.nequi.franquicias.model.Franchise;
import com.nequi.franquicias.repository.BranchRepository;
import com.nequi.franquicias.repository.FranchiseRepository;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {
    private final FranchiseRepository franchiseRepository;
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    public BranchServiceImpl(FranchiseRepository franchiseRepository, BranchRepository branchRepository, BranchMapper branchMapper) {
        this.franchiseRepository = franchiseRepository;
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
    }

    @Override
    public BranchResponse addBranchToFranchise(BranchRequest branchRequest) {
        Franchise franchise = franchiseRepository.findById(branchRequest.getFranchiseId())
                .orElseThrow(() -> new RuntimeException("Franchise not found"));
        Branch branch = branchMapper.toEntity(branchRequest);
        branch.setFranchise(franchise);
        Branch savedBranch = branchRepository.save(branch);
        return branchMapper.toResponse(savedBranch);
    }

    @Override
    public BranchResponse updateBranchName(Long branchId, BranchRequest newName) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        branch.setName(newName.getName());
        Branch updatedBranch = branchRepository.save(branch);
        return branchMapper.toResponse(updatedBranch);
    }
}
