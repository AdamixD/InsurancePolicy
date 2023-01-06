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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carModelIdGen")
    @SequenceGenerator(name = "carModelIdGen", sequenceName = "carModel_id_seq", allocationSize = 1)
    private Long id;
    private String brand;
    private String modelName;
    private String engineType;
    private Integer modelGeneration;
    private Float engineCapacity;
}
