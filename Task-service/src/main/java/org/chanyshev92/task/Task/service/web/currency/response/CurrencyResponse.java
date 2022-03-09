package org.chanyshev92.task.Task.service.web.currency.response;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyResponse {
    public String disclaimer;
    public String license;
    public int timestamp;
    public String base;
    public Map<String,Double> rates;
}
