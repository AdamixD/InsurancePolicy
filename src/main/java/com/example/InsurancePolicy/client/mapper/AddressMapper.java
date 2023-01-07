package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.AddressDTO;
import com.example.InsurancePolicy.client.entity.Address;
import com.example.InsurancePolicy.client.repository.AddressRepository;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressRepository.class})
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    @Mapping(expression = "java(addressRepository.getById(id))", target = "Address.class")
    Address toEntity(Long id);
}
