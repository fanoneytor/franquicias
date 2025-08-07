package com.nequi.franquicias.service;

import com.nequi.franquicias.controller.dto.ProductRequest;
import com.nequi.franquicias.controller.dto.ProductResponse;

public interface ProductService {
    ProductResponse addProductToBranch(ProductRequest productRequest);
    ProductResponse updateProductStock(Long productId, Integer newStock);
    void deleteProductFromBranch(Long productId);
}
