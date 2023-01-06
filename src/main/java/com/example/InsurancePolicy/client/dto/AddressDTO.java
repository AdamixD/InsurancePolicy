package com.example.InsurancePolicy.client.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class AddressDTO {
    private String street;
    private String postalCode;
    private String city;
    private String country;
}
