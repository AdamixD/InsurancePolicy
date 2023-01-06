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
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carIdGen")
    @SequenceGenerator(name = "carIdGen", sequenceName = "car_id_seq", allocationSize = 1)
    private Long id;
    private String registrationNumber;
    private String vinNumber;
    private LocalDateTime manufactureYear;
    private Long clientId; // TODO: przecież może mieć kilku właścicieli
    private Long carModelId;
}
