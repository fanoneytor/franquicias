package com.nequi.franquicias.application;

import com.nequi.franquicias.domain.model.Franchise;
import com.nequi.franquicias.infrastructure.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFranchiseService {

    private final FranchiseRepository franchiseRepository;

    public Franchise create(String name) {
        Franchise franchise = Franchise.builder()
                .name(name)
                .build();

        return franchiseRepository.save(franchise);
    }
}
