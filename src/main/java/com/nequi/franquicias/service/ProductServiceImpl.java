package com.nequi.franquicias.service;

import com.nequi.franquicias.controller.dto.ProductRequest;
import com.nequi.franquicias.controller.dto.ProductResponse;
import com.nequi.franquicias.mapper.ProductMapper;
import com.nequi.franquicias.model.Branch;
import com.nequi.franquicias.model.Product;
import com.nequi.franquicias.repository.BranchRepository;
import com.nequi.franquicias.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BranchRepository branchRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse addProductToBranch(ProductRequest productRequest) {
        Branch branch = branchRepository.findById(productRequest.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        Product product = productMapper.toEntity(productRequest);
        product.setBranch(branch);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductResponse updateProductStock(Long productId, Integer newStock) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStock(newStock);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProductFromBranch(Long productId) {
        productRepository.deleteById(productId);
    }
}
