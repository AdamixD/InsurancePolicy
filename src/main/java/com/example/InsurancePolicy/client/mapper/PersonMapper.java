package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.PersonDTO;
import com.example.InsurancePolicy.client.entity.Person;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = PersonMappingService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {
//    expression = "java(addressRepository.findById(dto.getAddress_id()).orElse(null))"
    @Mapping(target="address", source="address_id")
    Person toEntity(PersonDTO dto);
}
