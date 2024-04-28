package com.midnightsun.exchangeratessyncservice.service.mapper;

import com.midnightsun.exchangeratessyncservice.model.Currency;
import com.midnightsun.exchangeratessyncservice.service.dto.CurrencyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    CurrencyDTO toDTO(Currency currency);
}
