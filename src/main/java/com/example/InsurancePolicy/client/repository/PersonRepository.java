package com.example.InsurancePolicy.client.repository;

import com.example.InsurancePolicy.client.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
