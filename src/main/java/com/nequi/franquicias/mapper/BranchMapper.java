package com.nequi.franquicias.mapper;

import com.nequi.franquicias.controller.dto.BranchRequest;
import com.nequi.franquicias.controller.dto.BranchResponse;
import com.nequi.franquicias.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    @Mapping(target = "franchise", ignore = true)
    Branch toEntity(BranchRequest branchRequest);

    @Mapping(source = "franchise.id", target = "franchiseId")
    BranchResponse toResponse(Branch branch);
}