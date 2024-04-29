package com.midnightsun.exchangeratesconsumerservice.repository;

import com.midnightsun.exchangeratesconsumerservice.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
}
