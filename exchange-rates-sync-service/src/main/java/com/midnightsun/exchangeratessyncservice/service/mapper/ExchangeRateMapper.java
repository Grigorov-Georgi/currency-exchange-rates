package com.midnightsun.exchangeratessyncservice.service.mapper;

import com.midnightsun.exchangeratessyncservice.model.Currency;
import com.midnightsun.exchangeratessyncservice.model.ExchangeRate;
import com.midnightsun.exchangeratessyncservice.model.enums.CurrencyEnum;
import com.midnightsun.exchangeratessyncservice.repository.CurrencyRepository;
import com.midnightsun.exchangeratessyncservice.service.dto.CurrencyInfoDTO;
import com.midnightsun.exchangeratessyncservice.service.dto.ExchangeRateDTO;
import com.midnightsun.exchangeratessyncservice.service.dto.ExternalExchangeRateDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ExchangeRateMapper {
    private final CurrencyMapper currencyMapper;
    private final CurrencyRepository currencyRepository;

    public ExchangeRateMapper(CurrencyMapper currencyMapper, CurrencyRepository currencyRepository) {
        this.currencyMapper = currencyMapper;
        this.currencyRepository = currencyRepository;
    }

    public ExchangeRate toEntity(ExternalExchangeRateDTO dto) {
        if (dto == null) {
            return null;
        }

        ExchangeRate exchangeRate = new ExchangeRate();

        exchangeRate.setBase(CurrencyEnum.USD);
        exchangeRate.setEUR(dto.getEUR());
        exchangeRate.setJPY(dto.getJPY());
        exchangeRate.setGBP(dto.getGBP());
        exchangeRate.setAUD(dto.getAUD());
        exchangeRate.setCAD(dto.getCAD());
        exchangeRate.setCHF(dto.getCHF());
        exchangeRate.setCNY(dto.getCNY());
        exchangeRate.setHKD(dto.getHKD());
        exchangeRate.setSEK(dto.getSEK());
        exchangeRate.setNZD(dto.getNZD());
        exchangeRate.setKRW(dto.getKRW());
        exchangeRate.setSGD(dto.getSGD());
        exchangeRate.setNOK(dto.getNOK());
        exchangeRate.setMXN(dto.getMXN());
        exchangeRate.setINR(dto.getINR());
        exchangeRate.setBRL(dto.getBRL());
        exchangeRate.setRUB(dto.getRUB());
        exchangeRate.setZAR(dto.getZAR());
        exchangeRate.setTRY(dto.getTRY());

        return exchangeRate;
    }

    public ExchangeRateDTO toDTO(ExchangeRate entity) {
        if (entity == null) {
            return null;
        }

        Map<String, Currency> currenciesMap = currencyRepository.findAll().stream()
                .collect(Collectors.toMap(Currency::getNameEN, Function.identity()));

        ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO();
        exchangeRateDTO.setId(entity.getId());

        CurrencyInfoDTO base = new CurrencyInfoDTO();
        base.setCurrency(currencyMapper.toDTO(currenciesMap.get("USD")));
        base.setValue(BigDecimal.ONE);
        exchangeRateDTO.setBase(base);

        CurrencyInfoDTO eur = new CurrencyInfoDTO();
        eur.setCurrency(currencyMapper.toDTO(currenciesMap.get("EUR")));
        eur.setValue(entity.getEUR());
        exchangeRateDTO.setEUR(eur);

        CurrencyInfoDTO jpy = new CurrencyInfoDTO();
        jpy.setCurrency(currencyMapper.toDTO(currenciesMap.get("JPY")));
        jpy.setValue(entity.getJPY());
        exchangeRateDTO.setJPY(jpy);

        CurrencyInfoDTO gbp = new CurrencyInfoDTO();
        gbp.setCurrency(currencyMapper.toDTO(currenciesMap.get("GBP")));
        gbp.setValue(entity.getGBP());
        exchangeRateDTO.setGBP(gbp);

        CurrencyInfoDTO aud = new CurrencyInfoDTO();
        aud.setCurrency(currencyMapper.toDTO(currenciesMap.get("AUD")));
        aud.setValue(entity.getAUD());
        exchangeRateDTO.setAUD(aud);

        CurrencyInfoDTO cad = new CurrencyInfoDTO();
        cad.setCurrency(currencyMapper.toDTO(currenciesMap.get("CAD")));
        cad.setValue(entity.getCAD());
        exchangeRateDTO.setCAD(cad);

        CurrencyInfoDTO chf = new CurrencyInfoDTO();
        chf.setCurrency(currencyMapper.toDTO(currenciesMap.get("CHF")));
        chf.setValue(entity.getCHF());
        exchangeRateDTO.setCHF(chf);

        CurrencyInfoDTO cny = new CurrencyInfoDTO();
        cny.setCurrency(currencyMapper.toDTO(currenciesMap.get("CNY")));
        cny.setValue(entity.getCNY());
        exchangeRateDTO.setCNY(cny);

        CurrencyInfoDTO hkd = new CurrencyInfoDTO();
        hkd.setCurrency(currencyMapper.toDTO(currenciesMap.get("HKD")));
        hkd.setValue(entity.getHKD());
        exchangeRateDTO.setHKD(hkd);

        CurrencyInfoDTO sek = new CurrencyInfoDTO();
        sek.setCurrency(currencyMapper.toDTO(currenciesMap.get("SEK")));
        sek.setValue(entity.getSEK());
        exchangeRateDTO.setSEK(sek);

        CurrencyInfoDTO nzd = new CurrencyInfoDTO();
        nzd.setCurrency(currencyMapper.toDTO(currenciesMap.get("NZD")));
        nzd.setValue(entity.getNZD());
        exchangeRateDTO.setNZD(nzd);

        CurrencyInfoDTO krw = new CurrencyInfoDTO();
        krw.setCurrency(currencyMapper.toDTO(currenciesMap.get("KRW")));
        krw.setValue(entity.getKRW());
        exchangeRateDTO.setKRW(krw);

        CurrencyInfoDTO sgd = new CurrencyInfoDTO();
        sgd.setCurrency(currencyMapper.toDTO(currenciesMap.get("SGD")));
        sgd.setValue(entity.getSGD());
        exchangeRateDTO.setSGD(sgd);

        CurrencyInfoDTO nok = new CurrencyInfoDTO();
        nok.setCurrency(currencyMapper.toDTO(currenciesMap.get("NOK")));
        nok.setValue(entity.getNOK());
        exchangeRateDTO.setNOK(nok);

        CurrencyInfoDTO mxn = new CurrencyInfoDTO();
        mxn.setCurrency(currencyMapper.toDTO(currenciesMap.get("MXN")));
        mxn.setValue(entity.getMXN());
        exchangeRateDTO.setMXN(mxn);

        CurrencyInfoDTO inr = new CurrencyInfoDTO();
        inr.setCurrency(currencyMapper.toDTO(currenciesMap.get("INR")));
        inr.setValue(entity.getEUR());
        exchangeRateDTO.setINR(inr);

        CurrencyInfoDTO brl = new CurrencyInfoDTO();
        brl.setCurrency(currencyMapper.toDTO(currenciesMap.get("BRL")));
        brl.setValue(entity.getBRL());
        exchangeRateDTO.setBRL(brl);

        CurrencyInfoDTO rub = new CurrencyInfoDTO();
        rub.setCurrency(currencyMapper.toDTO(currenciesMap.get("RUB")));
        rub.setValue(entity.getRUB());
        exchangeRateDTO.setRUB(rub);

        CurrencyInfoDTO zar = new CurrencyInfoDTO();
        zar.setCurrency(currencyMapper.toDTO(currenciesMap.get("ZAR")));
        zar.setValue(entity.getZAR());
        exchangeRateDTO.setZAR(zar);

        CurrencyInfoDTO tryy = new CurrencyInfoDTO();
        tryy.setCurrency(currencyMapper.toDTO(currenciesMap.get("TRY")));
        tryy.setValue(entity.getTRY());
        exchangeRateDTO.setTRY(tryy);

        return exchangeRateDTO;
    }
}
