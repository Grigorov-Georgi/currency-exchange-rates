package com.midnightsun.exchangeratesconsumerservice.service.mapper;

import com.midnightsun.exchangeratesconsumerservice.model.ExchangeRate;
import com.midnightsun.exchangeratesconsumerservice.model.enums.CurrencyEnum;
import com.midnightsun.exchangeratesconsumerservice.service.dto.CurrencyInfoDTO;
import com.midnightsun.exchangeratesconsumerservice.service.dto.ExchangeRateDTO;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {

    ExchangeRate toEntity(ExchangeRateDTO dto);

    default BigDecimal map(CurrencyInfoDTO currencyInfoDTO) {
        return currencyInfoDTO.getValue();
    }

    default CurrencyEnum mapCurrencyCodeToEnum(CurrencyInfoDTO currencyInfoDTO) {
        return CurrencyEnum.valueOf(currencyInfoDTO.getCurrency().getNameEN());
    }
}
