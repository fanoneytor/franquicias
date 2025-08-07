package com.nequi.franquicias.infrastructure.repository;

import com.nequi.franquicias.domain.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
}
