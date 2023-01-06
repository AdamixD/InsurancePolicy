package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.AccidentDTO;
import com.example.InsurancePolicy.client.dto.ClientDTO;
import com.example.InsurancePolicy.client.entity.Accident;
import com.example.InsurancePolicy.client.entity.Client;
import com.example.InsurancePolicy.client.mapper.AccidentMapper;
import com.example.InsurancePolicy.client.mapper.ClientMapper;
import com.example.InsurancePolicy.client.repository.AccidentRepository;
import com.example.InsurancePolicy.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentService {
    private final AccidentRepository accidentRepository;
    private final AccidentMapper accidentMapper;

    public List<AccidentDTO> getAllAccidents() {
        return accidentMapper.toDto(accidentRepository.findAll());
    }

    public AccidentDTO getAccidentById(Long id) {
        return accidentMapper.toDto(accidentRepository.findById(id).orElse(null));
    }

    public Accident addAccident(AccidentDTO accident) {
        return accidentRepository.save(accidentMapper.toEntity(accident));
    }

    public Accident updateAccidentById(Long id, AccidentDTO accidentDTO) {
        Accident oldAccident = accidentRepository.getById(id);
        accidentMapper.updateEntity(oldAccident, accidentDTO);

        return accidentRepository.save(oldAccident);
    }

    public Long deleteAccidentById(Long id) {
        accidentRepository.deleteById(id);

        return id;
    }
}
