package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.AddressDTO;
import com.example.InsurancePolicy.client.entity.Address;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {}
