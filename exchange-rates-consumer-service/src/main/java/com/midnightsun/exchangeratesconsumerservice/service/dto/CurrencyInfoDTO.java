package com.midnightsun.exchangeratesconsumerservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInfoDTO {
    private CurrencyDTO currency;
    private BigDecimal value;
}