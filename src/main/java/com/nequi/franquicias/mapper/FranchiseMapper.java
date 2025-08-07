package com.nequi.franquicias.mapper;

import com.nequi.franquicias.controller.dto.FranchiseRequest;
import com.nequi.franquicias.controller.dto.FranchiseResponse;
import com.nequi.franquicias.model.Franchise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

    FranchiseMapper INSTANCE = Mappers.getMapper(FranchiseMapper.class);

    Franchise toEntity(FranchiseRequest franchiseRequest);

    FranchiseResponse toResponse(Franchise franchise);
}