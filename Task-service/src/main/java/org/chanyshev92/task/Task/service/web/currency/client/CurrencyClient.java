package org.chanyshev92.task.Task.service.web.currency.client;

import org.chanyshev92.task.Task.service.web.currency.response.Rates;

import java.time.LocalDate;

public interface CurrencyClient {

    Rates getRatesByDate(LocalDate localDate);
}
