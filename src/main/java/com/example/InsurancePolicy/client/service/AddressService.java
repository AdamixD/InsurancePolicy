package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.AddressDTO;
import com.example.InsurancePolicy.client.entity.Address;
import com.example.InsurancePolicy.client.mapper.AddressMapper;
import com.example.InsurancePolicy.client.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public List<AddressDTO> getAllAddresses() {
        return addressMapper.toDto(addressRepository.findAll());
    }

    public AddressDTO getAddressById(Long id) {
        return addressMapper.toDto(addressRepository.findById(id).orElse(null));
    }

    public Address addAddress(AddressDTO address) {
        return addressRepository.save(addressMapper.toEntity(address));
    }

    public Address updateAddressById(Long id, AddressDTO addressDTO) {
        Address oldAddress = addressRepository.getById(id);
        addressMapper.updateEntity(oldAddress, addressDTO);

        return addressRepository.save(oldAddress);
    }

    public Long deleteAddressById(Long id) {
        addressRepository.deleteById(id);

        return id;
    }
}
