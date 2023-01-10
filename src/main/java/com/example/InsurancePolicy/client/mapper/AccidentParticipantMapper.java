package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.AccidentParticipantDTO;
import com.example.InsurancePolicy.client.entity.AccidentParticipant;
import com.example.InsurancePolicy.client.mapper.service.PersonMapperService;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = PersonMapperService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AccidentParticipantMapper extends EntityMapper<AccidentParticipantDTO, AccidentParticipant> {
    @Mapping(target="persons", source="personIds")
    AccidentParticipant toEntity(AccidentParticipantDTO dto);
}
