package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.AccidentDTO;
import com.example.InsurancePolicy.client.entity.Accident;
import com.example.InsurancePolicy.client.mapper.service.AccidentParticipantMapperService;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = AccidentParticipantMapperService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AccidentMapper extends EntityMapper<AccidentDTO, Accident> {
    @Mapping(target="participants", source="participantIds")
    Accident toEntity(AccidentDTO dto);
}
