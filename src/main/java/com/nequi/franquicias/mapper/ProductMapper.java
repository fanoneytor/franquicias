package com.nequi.franquicias.mapper;

import com.nequi.franquicias.controller.dto.ProductRequest;
import com.nequi.franquicias.controller.dto.ProductResponse;
import com.nequi.franquicias.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "branch", ignore = true)
    Product toEntity(ProductRequest productRequest);

    @Mapping(source = "branch.id", target = "branchId")
    ProductResponse toDto(Product product);
}
