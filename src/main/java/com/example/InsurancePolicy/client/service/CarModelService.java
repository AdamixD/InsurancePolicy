package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.CarModelDTO;
import com.example.InsurancePolicy.client.entity.CarModel;
import com.example.InsurancePolicy.client.mapper.CarModelMapper;
import com.example.InsurancePolicy.client.repository.CarModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarModelService {
    private final CarModelRepository carModelRepository;
    private final CarModelMapper carModelMapper;

    public List<CarModelDTO> getAllCarModels() {
        return carModelMapper.toDto(carModelRepository.findAll());
    }

    public CarModelDTO getCarModelById(Long id) {
        return carModelMapper.toDto(carModelRepository.findById(id).orElse(null));
    }

    public CarModel addCarModel(CarModelDTO carModel) {
        return carModelRepository.save(carModelMapper.toEntity(carModel));
    }

    public CarModel updateCarModelById(Long id, CarModelDTO carModelDTO) {
        CarModel oldCarModel = carModelRepository.getById(id);
        carModelMapper.updateEntity(oldCarModel, carModelDTO);

        return carModelRepository.save(oldCarModel);
    }

    public Long deleteCarModelById(Long id) {
        carModelRepository.deleteById(id);

        return id;
    }
}
