package com.midnightsun.exchangeratesservice.repository;

import com.midnightsun.exchangeratesservice.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Query("SELECT ex FROM ExchangeRate ex ORDER BY ex.createdDate DESC LIMIT 1")
    ExchangeRate findMostRecent();
}
