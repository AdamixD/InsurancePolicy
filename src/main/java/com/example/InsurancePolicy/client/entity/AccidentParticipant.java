package com.example.InsurancePolicy.client.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class AccidentParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "accidentParticipantIdGen")
    private Long id;
    @NotNull
    private Boolean isResponsible;
    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Person> persons;
    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_vinNumber")
    private Car car;
}
