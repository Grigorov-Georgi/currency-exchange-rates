package com.midnightsun.exchangeratessyncservice.service.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "exchange-rates")
public class ExchangeRateDTO {

    @JacksonXmlProperty(localName = "excludedField")
    private Long id;

    private CurrencyInfoDTO base;

    private CurrencyInfoDTO EUR;
    private CurrencyInfoDTO JPY;
    private CurrencyInfoDTO GBP;
    private CurrencyInfoDTO AUD;
    private CurrencyInfoDTO CAD;
    private CurrencyInfoDTO CHF;
    private CurrencyInfoDTO CNY;
    private CurrencyInfoDTO HKD;
    private CurrencyInfoDTO SEK;
    private CurrencyInfoDTO NZD;
    private CurrencyInfoDTO KRW;
    private CurrencyInfoDTO SGD;
    private CurrencyInfoDTO NOK;
    private CurrencyInfoDTO MXN;
    private CurrencyInfoDTO INR;
    private CurrencyInfoDTO BRL;
    private CurrencyInfoDTO RUB;
    private CurrencyInfoDTO ZAR;
    private CurrencyInfoDTO TRY;
}
