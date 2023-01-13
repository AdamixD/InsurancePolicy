package com.example.InsurancePolicy.client.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    protected String name;
    @NotNull
    protected String surname;
    protected LocalDateTime birthDate;
    protected LocalDateTime drivingLicenceDate;
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    @NotNull
    protected Address address;
}
