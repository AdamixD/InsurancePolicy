package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.AccidentDTO;
import com.example.InsurancePolicy.client.entity.Accident;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccidentMapper extends EntityMapper<AccidentDTO, Accident> {}
