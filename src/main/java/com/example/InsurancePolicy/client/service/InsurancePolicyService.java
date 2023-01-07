package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.InsurancePolicyDTO;
import com.example.InsurancePolicy.client.entity.InsurancePolicy;
import com.example.InsurancePolicy.client.mapper.InsurancePolicyMapper;
import com.example.InsurancePolicy.client.repository.InsurancePolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsurancePolicyService {
    private final InsurancePolicyRepository insurancePolicyRepository;
    private final InsurancePolicyMapper insurancePolicyMapper;

    public List<InsurancePolicyDTO> getAllInsurancePolicies() {
        return insurancePolicyMapper.toDto(insurancePolicyRepository.findAll());
    }

    public InsurancePolicyDTO getInsurancePolicyById(Long id) {
        return insurancePolicyMapper.toDto(insurancePolicyRepository.findById(id).orElse(null));
    }

    public InsurancePolicy addInsurancePolicy(InsurancePolicyDTO insurancePolicy) {
        return insurancePolicyRepository.save(insurancePolicyMapper.toEntity(insurancePolicy));
    }

    public InsurancePolicy updateInsurancePolicyById(Long id, InsurancePolicyDTO insurancePolicyDTO) {
        InsurancePolicy oldInsurancePolicy = insurancePolicyRepository.getById(id);
        insurancePolicyMapper.updateEntity(oldInsurancePolicy, insurancePolicyDTO);

        return insurancePolicyRepository.save(oldInsurancePolicy);
    }

    public Long deleteInsurancePolicyById(Long id) {
        insurancePolicyRepository.deleteById(id);

        return id;
    }
}
