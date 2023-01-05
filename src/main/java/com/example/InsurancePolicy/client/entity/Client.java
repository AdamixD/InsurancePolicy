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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientIdGen")
    @SequenceGenerator(name = "clientIdGen", sequenceName = "client_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    private LocalDateTime birthDate;
    private LocalDateTime drivingLicenceDate;
    private Long addressId;
}
