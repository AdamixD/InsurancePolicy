package com.example.InsurancePolicy.client.mapper;


import com.example.InsurancePolicy.client.dto.ClientDTO;
import com.example.InsurancePolicy.client.entity.Client;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {}
