package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.AccidentParticipantDTO;
import com.example.InsurancePolicy.client.entity.AccidentParticipant;
import com.example.InsurancePolicy.client.mapper.AccidentParticipantMapper;
import com.example.InsurancePolicy.client.repository.AccidentParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentParticipantService {
    private final AccidentParticipantRepository accidentParticipantRepository;
    private final AccidentParticipantMapper accidentParticipantMapper;

    public List<AccidentParticipantDTO> getAllAccidentParticipants() {
        return accidentParticipantMapper.toDto(accidentParticipantRepository.findAll());
    }

    public AccidentParticipantDTO getAccidentParticipantById(Long id) {
        return accidentParticipantMapper.toDto(accidentParticipantRepository.findById(id).orElse(null));
    }

    public AccidentParticipant addAccidentParticipant(AccidentParticipantDTO accidentParticipant) {
        return accidentParticipantRepository.save(accidentParticipantMapper.toEntity(accidentParticipant));
    }

    public AccidentParticipant updateAccidentParticipantById(Long id, AccidentParticipantDTO accidentParticipantDTO) {
        AccidentParticipant oldAccidentParticipant = accidentParticipantRepository.getById(id);
        accidentParticipantMapper.updateEntity(oldAccidentParticipant, accidentParticipantDTO);

        return accidentParticipantRepository.save(oldAccidentParticipant);
    }

    public Long deleteAccidentParticipantById(Long id) {
        accidentParticipantRepository.deleteById(id);

        return id;
    }
}
