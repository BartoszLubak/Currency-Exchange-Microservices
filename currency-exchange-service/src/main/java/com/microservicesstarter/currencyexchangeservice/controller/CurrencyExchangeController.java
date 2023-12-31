package com.microservicesstarter.currencyexchangeservice.controller;

import com.microservicesstarter.currencyexchangeservice.model.CurrencyExchange;
import com.microservicesstarter.currencyexchangeservice.service.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    private final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    private final Environment environment;
    private final CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeService currencyExchangeService) {
        this.environment = environment;
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to) {
        logger.info("retrieveExchangeValue called with {} to {}", from, to);
        CurrencyExchange currencyExchange = currencyExchangeService.findCurrencyExchangeByFromAndTo(from, to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
