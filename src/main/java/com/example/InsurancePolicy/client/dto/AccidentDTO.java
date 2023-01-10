package com.example.InsurancePolicy.client.dto;

import com.example.InsurancePolicy.client.entity.AccidentParticipant;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldNameConstants
public class AccidentDTO {
    private String type;
    private LocalDateTime accidentDate;
    private List<Long> participantIds;
}
