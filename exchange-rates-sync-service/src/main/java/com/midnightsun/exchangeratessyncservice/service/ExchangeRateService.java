package com.midnightsun.exchangeratessyncservice.service;

import com.midnightsun.exchangeratessyncservice.service.dto.ExchangeRateDTO;
import com.midnightsun.exchangeratessyncservice.utils.XmlConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;

@Slf4j
@Service
public class ExchangeRateService {

    private final RestClient restClient;

    public ExchangeRateService(RestClient restClient) {
        this.restClient = restClient;
    }

    private ExchangeRateDTO fetchExchangeRates() {
        return restClient.get()
                .uri("http://localhost:8087/api/exchange-rates")
                .retrieve()
                .body(ExchangeRateDTO.class);
    }

    public byte[] getExchangeRatesFileContent() throws IOException {
        ExchangeRateDTO exchangeRateDTO = fetchExchangeRates();
        return XmlConverter.objectToXmlByteArray(exchangeRateDTO);
    }



}
