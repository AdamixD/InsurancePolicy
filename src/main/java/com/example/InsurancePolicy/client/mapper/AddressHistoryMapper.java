package com.example.InsurancePolicy.client.mapper;

import com.example.InsurancePolicy.client.dto.AddressHistoryDTO;
import com.example.InsurancePolicy.client.entity.AddressHistory;
import com.example.InsurancePolicy.client.mapper.service.AddressMappingService;
import com.example.InsurancePolicy.client.mapper.service.PersonMapperService;
import com.example.InsurancePolicy.general.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {PersonMapperService.class, AddressMappingService.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AddressHistoryMapper extends EntityMapper<AddressHistoryDTO, AddressHistory> {
    @Mapping(target="person", source="personId")
    @Mapping(target="oldAddress", source="oldAddressId")
    @Mapping(target="newAddress", source="newAddressId")
    AddressHistory toEntity(AddressHistoryDTO dto);

    @Mapping(target="personId", source="person")
    @Mapping(target="oldAddressId", source="oldAddress")
    @Mapping(target="newAddressId", source="newAddress")
    AddressHistoryDTO toDto(AddressHistory entity);
}
