package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.AddressHistoryDTO;
import com.example.InsurancePolicy.client.entity.AddressHistory;
import com.example.InsurancePolicy.client.mapper.AddressHistoryMapper;
import com.example.InsurancePolicy.client.repository.AddressHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressHistoryService {
    private final AddressHistoryRepository addressHistoryRepository;
    private final AddressHistoryMapper addressHistoryMapper;

    public List<AddressHistoryDTO> getAllAddressesHistory() {
        return addressHistoryMapper.toDto(addressHistoryRepository.findAll());
    }

    public AddressHistoryDTO getAddressHistoryById(Long id) {
        return addressHistoryMapper.toDto(addressHistoryRepository.findById(id).orElse(null));
    }

    public AddressHistory addAddressHistory(AddressHistoryDTO address) {
        return addressHistoryRepository.save(addressHistoryMapper.toEntity(address));
    }

    public AddressHistory updateAddressHistoryById(Long id, AddressHistoryDTO addressDTO) {
        AddressHistory oldAddress = addressHistoryRepository.getById(id);
        addressHistoryMapper.updateEntity(oldAddress, addressDTO);

        return addressHistoryRepository.save(oldAddress);
    }

    public Long deleteAddressHistoryById(Long id) {
        addressHistoryRepository.deleteById(id);

        return id;
    }
}
