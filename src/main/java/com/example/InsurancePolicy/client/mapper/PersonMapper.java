package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.PersonDTO;
import com.example.InsurancePolicy.client.entity.Person;
import com.example.InsurancePolicy.client.mapper.service.AddressMappingService;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = AddressMappingService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {
    @Mapping(target="address", source="address_id")
    Person toEntity(PersonDTO dto);
}
