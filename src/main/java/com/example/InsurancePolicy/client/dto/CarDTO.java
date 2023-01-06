package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Data
@FieldNameConstants
public class CarDTO {
    private String registrationNumber;
    private String vinNumber;
    private LocalDateTime manufactureYear;
    private Long clientId;
    private Long carModelId;
}
