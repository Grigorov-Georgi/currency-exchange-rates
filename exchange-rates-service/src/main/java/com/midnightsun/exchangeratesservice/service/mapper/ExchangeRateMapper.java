package com.midnightsun.exchangeratesservice.service.mapper;

import com.midnightsun.exchangeratesservice.model.ExchangeRate;
import com.midnightsun.exchangeratesservice.service.dto.ExchangeRateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    ExchangeRate toEntity(ExchangeRateDTO dto);

    ExchangeRateDTO toDTO(ExchangeRate entity);
}
