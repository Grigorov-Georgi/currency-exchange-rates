package com.midnightsun.exchangeratessyncservice.repository;

import com.midnightsun.exchangeratessyncservice.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Query("SELECT ex FROM ExchangeRate ex ORDER BY ex.createdDate DESC LIMIT 1")
    Optional<ExchangeRate> findMostRecent();

}
