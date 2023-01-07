package com.example.InsurancePolicy.client.dto;

import com.example.InsurancePolicy.client.entity.Car;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;
@Data
@FieldNameConstants
public class InsurancePolicyDTO {
    private Long insuranceAmount;
    private Long insurancePrice;
    private Long vinNumber;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
}
