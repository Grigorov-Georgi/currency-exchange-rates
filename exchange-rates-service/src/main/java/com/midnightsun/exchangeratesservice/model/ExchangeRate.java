package com.midnightsun.exchangeratesservice.model;

import com.midnightsun.exchangeratesservice.model.enums.CurrencyEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchange_rates")
public class ExchangeRate extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(generator = "exchange_rates_sequence_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "exchange_rates_sequence_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private CurrencyEnum base;

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
