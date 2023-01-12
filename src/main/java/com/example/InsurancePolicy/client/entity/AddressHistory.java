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
public class AddressHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "addressIdGen")
    private Long id;
    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "oldAddress_id")
    private Address oldAddress;
    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "newAddress_id")
    private Address newAddress;
    private LocalDateTime changeDate;
}
