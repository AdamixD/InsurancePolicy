package com.example.InsurancePolicy.client.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "carModelIdGen")
    private Long id;
    private String brand;
    private String modelName;
    private String engineType;
    private Long modelGeneration;
    private Long engineCapacity;
}
