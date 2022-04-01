package com.meli.java_quality_challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class District {
    private UUID id = UUID.randomUUID();
    private String name;
    private BigDecimal sqmValue;
}
