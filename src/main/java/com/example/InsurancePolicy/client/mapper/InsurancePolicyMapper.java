package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.InsurancePolicyDTO;
import com.example.InsurancePolicy.client.entity.InsurancePolicy;
import com.example.InsurancePolicy.client.mapper.service.CarMapperService;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = CarMapperService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface InsurancePolicyMapper extends EntityMapper<InsurancePolicyDTO, InsurancePolicy> {
    @Mapping(target="car", source="vinNumber")
    InsurancePolicy toEntity(InsurancePolicyDTO dto);
}
