package com.nequi.franquicias.controller.dto;

import lombok.Data;

@Data
public class BranchResponse {
    private Long id;
    private String name;
    private Long franchiseId;
}