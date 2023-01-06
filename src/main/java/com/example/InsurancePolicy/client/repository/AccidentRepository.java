package com.example.InsurancePolicy.client.repository;

import com.example.InsurancePolicy.client.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {}
