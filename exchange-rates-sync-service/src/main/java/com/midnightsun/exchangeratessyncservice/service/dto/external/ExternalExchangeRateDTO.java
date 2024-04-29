package com.midnightsun.exchangeratessyncservice.service.dto.external;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExternalExchangeRateDTO {

    private String base;

    private BigDecimal EUR;
    private BigDecimal JPY;
    private BigDecimal GBP;
    private BigDecimal AUD;
    private BigDecimal CAD;
    private BigDecimal CHF;
    private BigDecimal CNY;
    private BigDecimal HKD;
    private BigDecimal SEK;
    private BigDecimal NZD;
    private BigDecimal KRW;
    private BigDecimal SGD;
    private BigDecimal NOK;
    private BigDecimal MXN;
    private BigDecimal INR;
    private BigDecimal BRL;
    private BigDecimal RUB;
    private BigDecimal ZAR;
    private BigDecimal TRY;
}
