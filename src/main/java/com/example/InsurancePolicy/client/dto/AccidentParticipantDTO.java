package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Data
@FieldNameConstants
public class AccidentParticipantDTO {
    private Boolean isResponsible;
    private List<Long> personIds;
    private String carNumber;
}
