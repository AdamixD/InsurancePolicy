package com.example.InsurancePolicy.general;

import org.mapstruct.*;

import java.util.List;

public interface EntityMapper <D, E> {
    public E toEntity(D dto);
    public D toDto(E entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateEntity(@MappingTarget E entity, D dto);
    public List<E> toEntity(List<D> dtoList);
    public List <D> toDto(List<E> entityList);
}
