package com.meli.java_quality_challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    private UUID id = UUID.randomUUID();
    private String name;
    private Double width;
    private Double height;
}
