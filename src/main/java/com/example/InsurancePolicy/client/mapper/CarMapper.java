package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.CarDTO;
import com.example.InsurancePolicy.client.entity.Car;
import com.example.InsurancePolicy.client.mapper.service.PersonMapperService;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = PersonMapperService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CarMapper extends EntityMapper<CarDTO, Car> {
    @Mapping(target="persons", source="personIds")
    Car toEntity(CarDTO dto);
}
