package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class CarModelDTO {
    private String brand;
    private String modelName;
    private String engineType;
    private Integer modelGeneration;
    private Float engineCapacity;
}
