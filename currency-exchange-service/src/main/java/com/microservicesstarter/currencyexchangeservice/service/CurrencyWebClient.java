package com.microservicesstarter.currencyexchangeservice.service;

import com.microservicesstarter.currencyexchangeservice.dto.CurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyWebClient {
    public static final String CURRENCY_EXCHANGE_TABLE_URL = "https://cdn.kurs-walut.info/api/latest.json";
    private RestTemplate restTemplate = new RestTemplate();

    public CurrencyWebClient() {
    }

    public CurrencyDto getCurrencyData() {
        ResponseEntity<CurrencyDto> response = restTemplate.getForEntity(CURRENCY_EXCHANGE_TABLE_URL, CurrencyDto.class);
        return response.getBody();
    }
}
