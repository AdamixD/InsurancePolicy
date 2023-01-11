package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.CarDTO;
import com.example.InsurancePolicy.client.entity.Car;
import com.example.InsurancePolicy.client.mapper.service.CarModelMapperService;
import com.example.InsurancePolicy.client.mapper.service.PersonMapperService;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {PersonMapperService.class, CarModelMapperService.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CarMapper extends EntityMapper<CarDTO, Car> {
    @Mapping(target="persons", source="personIds")
    @Mapping(target="carModel", source="carModelId")
    Car toEntity(CarDTO dto);

    @Mapping(target="personIds", source="persons")
    @Mapping(target="carModelId", source="carModel")
    CarDTO toDto(Car entity);
}
