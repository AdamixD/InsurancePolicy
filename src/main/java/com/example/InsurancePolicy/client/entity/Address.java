package com.example.InsurancePolicy.client.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "addressIdGen")
    private Long id;
    private String street;
    private String postalCode;
    private String city;
    private String country;
}
