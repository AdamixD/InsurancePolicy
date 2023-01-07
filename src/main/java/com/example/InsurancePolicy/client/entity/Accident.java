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
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accidentIdGen")
    @SequenceGenerator(name = "accidentIdGen", sequenceName = "accident_id_seq", allocationSize = 1)
    private Long id;
    private String type;
    private LocalDateTime accidentDate;
    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<AccidentParticipant> participants;
}
