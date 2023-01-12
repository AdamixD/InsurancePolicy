package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Data
@FieldNameConstants
public class AddressHistoryDTO {
    private Long personId;
    private Long oldAddressId;
    private Long newAddressId;
    private LocalDateTime changeDate;
}
