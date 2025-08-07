package com.nequi.franquicias.service;

import com.nequi.franquicias.controller.dto.ProductRequest;
import com.nequi.franquicias.controller.dto.ProductResponse;

import com.nequi.franquicias.controller.dto.ProductWithBranchInfoResponse;

import java.util.List;

public interface ProductService {
    ProductResponse addProductToBranch(ProductRequest productRequest);

    ProductResponse updateProductStock(Long productId, Integer newStock);

    void deleteProductFromBranch(Long productId);

    ProductResponse updateProductName(Long productId, String newName);

    List<ProductWithBranchInfoResponse> getProductsWithMostStockPerBranchForFranchise(Long franchiseId);
}
