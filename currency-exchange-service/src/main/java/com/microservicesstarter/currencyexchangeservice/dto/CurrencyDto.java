package com.microservicesstarter.currencyexchangeservice.dto;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyDto {
    public String table;
    public Map<String, BigDecimal> rates;
    public String latestUpdate;

    public CurrencyDto(String table, Map rates, String latestUpdate) {
        this.table = table;
        this.rates = rates;
        this.latestUpdate = latestUpdate;
    }

    public CurrencyDto() {
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    public String getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(String latestUpdate) {
        this.latestUpdate = latestUpdate;
    }
}
