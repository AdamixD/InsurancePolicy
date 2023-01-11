package com.example.InsurancePolicy.client.mapper.service;

import com.example.InsurancePolicy.client.entity.Car;
import com.example.InsurancePolicy.client.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarMapperService {
    private final CarRepository carRepository;

    public Car getCarById(String vinNumber) {
        return carRepository.getCarByVinNumber(vinNumber);
    }

    public String getVinNumber(Car car) {
        return car.getVinNumber();
    }
}
