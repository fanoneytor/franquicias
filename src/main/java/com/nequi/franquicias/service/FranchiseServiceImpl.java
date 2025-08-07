package com.nequi.franquicias.service;

import com.nequi.franquicias.dto.FranchiseRequest;
import com.nequi.franquicias.dto.FranchiseResponse;
import com.nequi.franquicias.mapper.FranchiseMapper;
import com.nequi.franquicias.model.Franchise;
import com.nequi.franquicias.repository.FranchiseRepository;
import org.springframework.stereotype.Service;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final FranchiseMapper franchiseMapper;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, FranchiseMapper franchiseMapper) {
        this.franchiseRepository = franchiseRepository;
        this.franchiseMapper = franchiseMapper;
    }

    @Override
    public FranchiseResponse createFranchise(FranchiseRequest franchiseRequest) {
        Franchise franchise = franchiseMapper.toEntity(franchiseRequest);
        Franchise savedFranchise = franchiseRepository.save(franchise);
        return franchiseMapper.toResponse(savedFranchise);
    }

    @Override
    public FranchiseResponse updateFranchiseName(Long id, FranchiseRequest newName) {
        Franchise franchise = franchiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franchise not found"));
        franchise.setName(newName.getName());
        Franchise updatedFranchise = franchiseRepository.save(franchise);
        return franchiseMapper.toResponse(updatedFranchise);
    }
}
