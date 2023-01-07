package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Data
@FieldNameConstants
public class PersonDTO {
    protected String name;
    protected String surname;
    protected LocalDateTime birthDate;
    protected LocalDateTime drivingLicenceDate;
    protected Long address_id;
}
