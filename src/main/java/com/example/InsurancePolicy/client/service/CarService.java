package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.CarDTO;
import com.example.InsurancePolicy.client.entity.Car;
import com.example.InsurancePolicy.client.mapper.CarMapper;
import com.example.InsurancePolicy.client.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDTO> getAllCars() {
        return carMapper.toDto(carRepository.findAll());
    }

    public CarDTO getCarById(Long id) {
        return carMapper.toDto(carRepository.findById(id).orElse(null));
    }

    public Car addCar(CarDTO car) {
        return carRepository.save(carMapper.toEntity(car));
    }

    public Car updateCarById(Long id, CarDTO carDTO) {
        Car oldCar = carRepository.getById(id);
        carMapper.updateEntity(oldCar, carDTO);

        return carRepository.save(oldCar);
    }

    public Long deleteCarById(Long id) {
        carRepository.deleteById(id);

        return id;
    }
}
