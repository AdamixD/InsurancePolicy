package com.example.InsurancePolicy.client.repository;

import com.example.InsurancePolicy.client.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {}
