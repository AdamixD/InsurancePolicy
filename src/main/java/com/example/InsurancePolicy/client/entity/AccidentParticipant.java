package com.example.InsurancePolicy.client.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accidentParticipantIdGen")
    @SequenceGenerator(name = "accidentParticipantIdGen", sequenceName = "accidentParticipant_id_seq", allocationSize = 1)
    private Long id;
    private Boolean isResponsible;
    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Person> persons;
    private String carNumber;
}
