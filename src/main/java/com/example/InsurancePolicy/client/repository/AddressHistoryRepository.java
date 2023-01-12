package com.example.InsurancePolicy.client.repository;

import com.example.InsurancePolicy.client.entity.AddressHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressHistoryRepository extends JpaRepository<AddressHistory, Long> {}
