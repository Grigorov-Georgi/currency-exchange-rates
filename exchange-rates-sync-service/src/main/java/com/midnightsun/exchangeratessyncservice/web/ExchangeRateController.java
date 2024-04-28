package com.midnightsun.exchangeratessyncservice.web;

import com.midnightsun.exchangeratessyncservice.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/exchange-rates-sync")
public class ExchangeRateController {
//    /download-currencies
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/download-currencies")
    public void downloadExchangeRates() {
        log.info("REST request to download exchange rates");
        exchangeRateService.fetchExchangeRates();
    }
}
