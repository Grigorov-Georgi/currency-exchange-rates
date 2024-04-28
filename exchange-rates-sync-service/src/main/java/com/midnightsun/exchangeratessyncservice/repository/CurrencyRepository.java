package com.midnightsun.exchangeratessyncservice.repository;

import com.midnightsun.exchangeratessyncservice.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
