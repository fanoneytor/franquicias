package com.nequi.franquicias.controller.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Integer stock;
    private Long branchId;
}
