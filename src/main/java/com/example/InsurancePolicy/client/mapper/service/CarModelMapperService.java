package com.example.InsurancePolicy.client.mapper.service;

import com.example.InsurancePolicy.client.entity.CarModel;
import com.example.InsurancePolicy.client.repository.CarModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarModelMapperService {
    private final CarModelRepository carModelRepository;

    public CarModel getCarModel(Long carModelId) {
        return carModelRepository.getById(carModelId);
    }

    public Long getCarId(CarModel carModel) {
        return carModel.getId();
    }
}
