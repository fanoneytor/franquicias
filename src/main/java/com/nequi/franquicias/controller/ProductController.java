package com.nequi.franquicias.controller;

import com.nequi.franquicias.controller.dto.ProductRequest;
import com.nequi.franquicias.controller.dto.ProductResponse;
import com.nequi.franquicias.controller.dto.ProductWithBranchInfoResponse;
import com.nequi.franquicias.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> addProductToBranch(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.addProductToBranch(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}/stock")
    public ResponseEntity<ProductResponse> updateProductStock(@PathVariable Long productId, @RequestParam Integer newStock) {
        ProductResponse productResponse = productService.updateProductStock(productId, newStock);
        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductFromBranch(@PathVariable Long productId) {
        productService.deleteProductFromBranch(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/most-stock-per-branch/franchise/{franchiseId}")
    public ResponseEntity<List<ProductWithBranchInfoResponse>> getProductsWithMostStockPerBranchForFranchise(@PathVariable Long franchiseId) {
        List<ProductWithBranchInfoResponse> products = productService.getProductsWithMostStockPerBranchForFranchise(franchiseId);
        return ResponseEntity.ok(products);
    }

}
