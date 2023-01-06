package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class AccidentParticipantDTO {
    private Boolean isResponsible;
    private Long personId;
    private String carNumber;
}
