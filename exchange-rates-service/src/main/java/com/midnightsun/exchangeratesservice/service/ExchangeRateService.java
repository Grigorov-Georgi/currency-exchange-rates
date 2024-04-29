package com.midnightsun.exchangeratesservice.service;

import com.midnightsun.exchangeratesservice.model.ExchangeRate;
import com.midnightsun.exchangeratesservice.model.enums.CurrencyEnum;
import com.midnightsun.exchangeratesservice.repository.ExchangeRateRepository;
import com.midnightsun.exchangeratesservice.service.dto.ExchangeRateDTO;
import com.midnightsun.exchangeratesservice.service.mapper.ExchangeRateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Slf4j
@Service
public class ExchangeRateService {

    private final Random random = new Random();

    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository, ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateMapper = exchangeRateMapper;
    }

    public ExchangeRateDTO findMostRecentExchangeRates() {
        log.info("Fetching most recent exchange rates");
        final var mostRecentEntry = exchangeRateRepository.findMostRecent();
        return exchangeRateMapper.toDTO(mostRecentEntry);
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void invalidateProductsCache() {
        log.info("Scheduled job to add random exchange rates started");

        final var exchangeRate = new ExchangeRate();
        exchangeRate.setBase(CurrencyEnum.USD);

        exchangeRate.setAUD(getRandomBigDecimal());
        exchangeRate.setCNY(getRandomBigDecimal());
        exchangeRate.setBRL(getRandomBigDecimal());
        exchangeRate.setCHF(getRandomBigDecimal());
        exchangeRate.setEUR(getRandomBigDecimal());
        exchangeRate.setINR(getRandomBigDecimal());
        exchangeRate.setJPY(getRandomBigDecimal());
        exchangeRate.setGBP(getRandomBigDecimal());
        exchangeRate.setMXN(getRandomBigDecimal());
        exchangeRate.setNZD(getRandomBigDecimal());
        exchangeRate.setRUB(getRandomBigDecimal());
        exchangeRate.setZAR(getRandomBigDecimal());
        exchangeRate.setTRY(getRandomBigDecimal());
        exchangeRate.setSGD(getRandomBigDecimal());
        exchangeRate.setNOK(getRandomBigDecimal());
        exchangeRate.setCAD(getRandomBigDecimal());
        exchangeRate.setHKD(getRandomBigDecimal());
        exchangeRate.setSEK(getRandomBigDecimal());
        exchangeRate.setKRW(getRandomBigDecimal());

        exchangeRateRepository.save(exchangeRate);
    }

    private BigDecimal getRandomBigDecimal() {
        final var randomDouble = random.nextDouble();
        return BigDecimal.valueOf(randomDouble).multiply(BigDecimal.valueOf(4L));
    }
}
