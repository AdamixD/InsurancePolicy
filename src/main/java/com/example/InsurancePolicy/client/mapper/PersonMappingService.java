package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.entity.Address;
import com.example.InsurancePolicy.client.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMappingService {
    private final AddressRepository addressRepository;

    public Address getAddressById(Long id){
        return addressRepository.findById(id).orElse(null);
    }
}
