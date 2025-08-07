package com.nequi.franquicias.controller.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Integer stock;
    private Long branchId;
}
