package com.nequi.franquicias.infrastructure.repository;

import com.nequi.franquicias.domain.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
