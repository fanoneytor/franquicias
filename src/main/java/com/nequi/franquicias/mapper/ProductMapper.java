package com.nequi.franquicias.mapper;

import com.nequi.franquicias.controller.dto.ProductRequest;
import com.nequi.franquicias.controller.dto.ProductResponse;
import com.nequi.franquicias.controller.dto.ProductWithBranchInfoResponse;
import com.nequi.franquicias.model.Product;
import com.nequi.franquicias.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "branch", ignore = true)
    Product toEntity(ProductRequest productRequest);

    @Mapping(source = "branch.id", target = "branchId")
    ProductResponse toDto(Product product);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.stock", target = "stock")
    @Mapping(source = "branch.id", target = "branchId")
    @Mapping(source = "branch.name", target = "branchName")
    ProductWithBranchInfoResponse toProductWithBranchInfoResponse(Product product, Branch branch);
}
