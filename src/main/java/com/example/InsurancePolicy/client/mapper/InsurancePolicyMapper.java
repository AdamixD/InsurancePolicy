package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.CarModelDTO;
import com.example.InsurancePolicy.client.dto.InsurancePolicyDTO;
import com.example.InsurancePolicy.client.entity.CarModel;
import com.example.InsurancePolicy.client.entity.InsurancePolicy;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsurancePolicyMapper extends EntityMapper<InsurancePolicyDTO, InsurancePolicy> {}
