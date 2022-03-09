package org.chanyshev92.task.Task.service.web.currency.client;

import org.chanyshev92.task.Task.service.web.currency.response.CurrencyResponse;

import java.time.LocalDate;

public interface CurrencyClient {

    CurrencyResponse getRatesByDate(LocalDate localDate);
}
