package com.nequi.franquicias.controller.dto;

import lombok.Data;

@Data
public class ProductWithBranchInfoResponse {
    private Long productId;
    private String productName;
    private Integer stock;
    private Long branchId;
    private String branchName;
}
