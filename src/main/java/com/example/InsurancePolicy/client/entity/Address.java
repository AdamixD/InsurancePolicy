package com.example.InsurancePolicy.client.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressIdGen")
    @SequenceGenerator(name = "addressIdGen", sequenceName = "address_id_seq", allocationSize = 1)
    private Long id;
    private String street;
    private String postalCode;
    private String city;
    private String country;
}
