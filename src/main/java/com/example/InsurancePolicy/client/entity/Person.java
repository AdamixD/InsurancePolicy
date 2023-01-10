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
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "personIdGen")
    protected Long id;
    protected String name;
    protected String surname;
    protected LocalDateTime birthDate;
    protected LocalDateTime drivingLicenceDate;
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    protected Address address;
}
