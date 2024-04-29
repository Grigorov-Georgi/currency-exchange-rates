package com.midnightsun.exchangeratessyncservice.utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.midnightsun.exchangeratessyncservice.service.dto.ExchangeRateDTO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class XmlConverter {

    public static byte[] objectToXmlByteArray(ExchangeRateDTO dto) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        if (dto != null) {
            xmlMapper.writeValue(outputStream, dto);
        }

        return outputStream.toByteArray();
    }
}
