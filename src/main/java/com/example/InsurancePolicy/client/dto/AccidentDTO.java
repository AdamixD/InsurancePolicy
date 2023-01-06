package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Data
@FieldNameConstants
public class AccidentDTO {
    private String type;
    private LocalDateTime accidentDate;
    private Long participantId; // TODO: według mnie tutaj powinna byc lista
}
