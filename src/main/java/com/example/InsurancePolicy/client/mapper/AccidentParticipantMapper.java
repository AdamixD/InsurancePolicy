package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.AccidentParticipantDTO;
import com.example.InsurancePolicy.client.entity.AccidentParticipant;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccidentParticipantMapper extends EntityMapper<AccidentParticipantDTO, AccidentParticipant> {}
