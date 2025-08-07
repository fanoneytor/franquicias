package com.nequi.franquicias.service;

import com.nequi.franquicias.controller.dto.ProductRequest;
import com.nequi.franquicias.controller.dto.ProductResponse;
import com.nequi.franquicias.controller.dto.ProductWithBranchInfoResponse;
import com.nequi.franquicias.mapper.ProductMapper;
import com.nequi.franquicias.model.Branch;
import com.nequi.franquicias.model.Franchise;
import com.nequi.franquicias.model.Product;
import com.nequi.franquicias.repository.BranchRepository;
import com.nequi.franquicias.repository.FranchiseRepository;
import com.nequi.franquicias.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;
    private final FranchiseRepository franchiseRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BranchRepository branchRepository, FranchiseRepository franchiseRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
        this.franchiseRepository = franchiseRepository;
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

    @Override
    public ProductResponse updateProductName(Long productId, String newName) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(newName);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public List<ProductWithBranchInfoResponse> getProductsWithMostStockPerBranchForFranchise(Long franchiseId) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franchise not found"));

        List<ProductWithBranchInfoResponse> result = new ArrayList<>();

        for (Branch branch : franchise.getBranches()) {
            Product productWithMostStock = branch.getProducts().stream()
                    .max(Comparator.comparingInt(Product::getStock))
                    .orElse(null);

            if (productWithMostStock != null) {
                result.add(productMapper.toProductWithBranchInfoResponse(productWithMostStock, branch));
            }
        }
        return result;
    }
}
