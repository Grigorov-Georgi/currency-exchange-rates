package com.midnightsun.exchangeratesconsumerservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateDTO {
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
