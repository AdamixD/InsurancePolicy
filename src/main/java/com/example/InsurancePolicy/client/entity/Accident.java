package com.example.InsurancePolicy.client.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "accidentIdGen")
    private Long id;
    @NotNull
    private String type;
    @NotNull
    private LocalDateTime accidentDate;
    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @NotNull
    private List<AccidentParticipant> participants;
}
