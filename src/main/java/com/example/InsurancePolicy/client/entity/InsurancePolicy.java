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
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "insurancePolicyIdGen")
    @SequenceGenerator(name = "insurancePolicyIdGen", sequenceName = "insurance_policy_id_seq", allocationSize = 1)
    private Long id;
    private Long insuranceAmount;
    private Long insurancePrice;
    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_vinNumber")
    private Car car;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
}
