package com.example.InsurancePolicy.client.mapper.service;

import com.example.InsurancePolicy.client.entity.AccidentParticipant;
import com.example.InsurancePolicy.client.repository.AccidentParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccidentParticipantMapperService {
    private final AccidentParticipantRepository accidentParticipantRepository;
    public List<AccidentParticipant> getAccidentsParticipantByIds(List<Long> accidentIds){
        return accidentParticipantRepository.findAllById(accidentIds);
    }

    public List<Long> getAccidentIds(List<AccidentParticipant> accidentParticipantList) {
        return accidentParticipantList.stream().map(AccidentParticipant::getId).collect(Collectors.toList());
    }
}
