package com.midnightsun.exchangeratessyncservice.service.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@JacksonXmlRootElement(localName = "exchange-rates")
public class ExchangeRateDTO {

    private String base;

    @XmlElement(name = "eur")
    private BigDecimal EUR;

    @XmlElement(name = "jpy")
    private BigDecimal JPY;

    @XmlElement(name = "gbp")
    private BigDecimal GBP;

    @XmlElement(name = "aud")
    private BigDecimal AUD;

    @XmlElement(name = "cad")
    private BigDecimal CAD;

    @XmlElement(name = "chf")
    private BigDecimal CHF;

    @XmlElement(name = "cny")
    private BigDecimal CNY;

    @XmlElement(name = "hkd")
    private BigDecimal HKD;

    @XmlElement(name = "sek")
    private BigDecimal SEK;

    @XmlElement(name = "nzd")
    private BigDecimal NZD;

    @XmlElement(name = "krw")
    private BigDecimal KRW;

    @XmlElement(name = "sgd")
    private BigDecimal SGD;

    @XmlElement(name = "nok")
    private BigDecimal NOK;

    @XmlElement(name = "mxn")
    private BigDecimal MXN;

    @XmlElement(name = "inr")
    private BigDecimal INR;

    @XmlElement(name = "brl")
    private BigDecimal BRL;

    @XmlElement(name = "rub")
    private BigDecimal RUB;

    @XmlElement(name = "zar")
    private BigDecimal ZAR;

    @XmlElement(name = "try")
    private BigDecimal TRY;
}
