package com.microservicesstarter.currencyexchangeservice.service;

import com.microservicesstarter.currencyexchangeservice.model.CurrencyExchange;
import com.microservicesstarter.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public CurrencyExchange findCurrencyExchangeByFromAndTo(String from, String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currencyExchange==null){
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }
        return  currencyExchange;
    }
}
