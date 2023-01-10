package com.example.InsurancePolicy.client.repository;

import com.example.InsurancePolicy.client.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car getCarByVinNumber(String vinNumber);
}