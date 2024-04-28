package com.midnightsun.exchangeratessyncservice.utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.midnightsun.exchangeratessyncservice.service.dto.ExternalExchangeRateDTO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class XmlConverter {

    public static byte[] objectToXmlByteArray(ExternalExchangeRateDTO obj) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(outputStream, obj);
        return outputStream.toByteArray();
    }
}
