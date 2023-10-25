package com.microservicesstarter.currencyexchangeservice.service;

import com.microservicesstarter.currencyexchangeservice.dto.CurrencyDto;
import com.microservicesstarter.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class CurrencyExchangeService {
    private final CurrencyWebClient currencyWebClient;

    public CurrencyExchangeService(CurrencyWebClient currencyWebClient) {
        this.currencyWebClient = currencyWebClient;
    }


    public CurrencyExchange findCurrencyExchangeByFromAndTo(String from, String to) {
        CurrencyExchange currencyExchange = new CurrencyExchange();
        currencyExchange.setFrom(from);
        currencyExchange.setTo(to);
        currencyExchange.setConversionMultiple(currencyExchangeToUSD(to).divide(currencyExchangeToUSD(from), 2, RoundingMode.HALF_UP));
        return currencyExchange;
    }

    public BigDecimal currencyExchangeToUSD(String currencyCode) {
        CurrencyDto currencyDto = currencyWebClient.getCurrencyData();
        Map<String, BigDecimal> rates = currencyDto.getRates();
        return rates.get(currencyCode);
    }

}
