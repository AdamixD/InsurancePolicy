package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.AccidentParticipantDTO;
import com.example.InsurancePolicy.client.entity.AccidentParticipant;
import com.example.InsurancePolicy.client.mapper.service.CarMapperService;
import com.example.InsurancePolicy.client.mapper.service.PersonMapperService;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {PersonMapperService.class, CarMapperService.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AccidentParticipantMapper extends EntityMapper<AccidentParticipantDTO, AccidentParticipant> {
    @Mapping(target="persons", source="personIds")
    @Mapping(target="car", source="vinNumber")
    AccidentParticipant toEntity(AccidentParticipantDTO dto);

    @Mapping(target="personIds", source="persons")
    @Mapping(target="vinNumber", source="car")
    AccidentParticipantDTO toDto(AccidentParticipant entity);
}
