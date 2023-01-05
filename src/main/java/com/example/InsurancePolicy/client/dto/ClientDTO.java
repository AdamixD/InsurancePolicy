package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Data
@FieldNameConstants
public class ClientDTO {
    private String name;
    private String surname;
    private LocalDateTime birthDate;
    private LocalDateTime drivingLicenceDate;
    private Long addressId;
}
