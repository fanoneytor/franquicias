package com.nequi.franquicias.dto;

import lombok.Data;

@Data
public class BranchRequest {
    private String name;
    private Long franchiseId;
}