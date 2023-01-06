package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.CarDTO;
import com.example.InsurancePolicy.client.entity.Car;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper extends EntityMapper<CarDTO, Car> {}
