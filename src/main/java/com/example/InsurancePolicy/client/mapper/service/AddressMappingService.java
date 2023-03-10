package com.example.InsurancePolicy.client.mapper.service;

import com.example.InsurancePolicy.client.entity.AccidentParticipant;
import com.example.InsurancePolicy.client.entity.Address;
import com.example.InsurancePolicy.client.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AddressMappingService {
    private final AddressRepository addressRepository;

    public Address getAddressById(Long id){
        return addressRepository.findById(id).orElse(null);
    }

    public Long getAddressId(Address address) {
        return address.getId();
    }
}
