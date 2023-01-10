package com.example.InsurancePolicy.client.dto;

import com.example.InsurancePolicy.client.entity.Person;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldNameConstants
public class CarDTO {
    private String registrationNumber;
    private String vinNumber;
    private LocalDateTime manufactureYear;
    private List<Long> personIds;
    private Long carModelId;
}
