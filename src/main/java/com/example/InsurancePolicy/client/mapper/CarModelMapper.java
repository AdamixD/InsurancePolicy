package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.CarModelDTO;
import com.example.InsurancePolicy.client.entity.CarModel;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarModelMapper extends EntityMapper<CarModelDTO, CarModel> {}
