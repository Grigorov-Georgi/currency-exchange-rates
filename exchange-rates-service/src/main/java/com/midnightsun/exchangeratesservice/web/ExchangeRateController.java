package com.midnightsun.exchangeratesservice.web;

import com.midnightsun.exchangeratesservice.service.ExchangeRateService;
import com.midnightsun.exchangeratesservice.service.dto.ExchangeRateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/exchange-rates", produces = "application/xml")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public ResponseEntity<ExchangeRateDTO> getMostRecentExchangeRates() {
        log.info("REST request to get most recent exchange rates");
        final var exchangeRates = exchangeRateService.findMostRecentExchangeRates();

        return new ResponseEntity<>(
                exchangeRates,
                HttpStatus.OK
        );
    }
}
