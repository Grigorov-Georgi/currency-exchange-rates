package com.midnightsun.exchangeratessyncservice.web;

import com.midnightsun.exchangeratessyncservice.service.ExchangeRateService;
import com.midnightsun.exchangeratessyncservice.service.dto.ExchangeRateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/exchange-rates-sync")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/download-currencies")
    public ResponseEntity<byte[]> downloadExchangeRates() {
        log.info("REST request to download exchange rates");

        byte[] fileContent;
        try {
            fileContent = exchangeRateService.getExchangeRatesFileContent();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "exchange-rates.txt");

        return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ExchangeRateDTO> getMostRecent() {
        log.info("REST request to get most recent exchange rates");
        return new ResponseEntity<>(
                exchangeRateService.getMostRecentExchangeRates(),
                HttpStatus.OK
        );
    }
}
