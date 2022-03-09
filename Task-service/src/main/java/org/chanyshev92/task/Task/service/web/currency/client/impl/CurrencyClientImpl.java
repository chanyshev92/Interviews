package org.chanyshev92.task.Task.service.web.currency.client.impl;

import lombok.RequiredArgsConstructor;
import org.chanyshev92.task.Task.service.web.currency.client.CurrencyClient;
import org.chanyshev92.task.Task.service.web.currency.response.CurrencyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CurrencyClientImpl implements CurrencyClient {

    private final RestTemplate restTemplate;

    private String url;

    @Value("${currency.code.id}")
    private String codeId;

    @Value("${currency.get-rates.method}") String methodValue;


    @Override
    public CurrencyResponse getRatesByDate(LocalDate localDate) {
        StringBuilder urlString = new StringBuilder();
        urlString
                .append(methodValue)
                .append("/")
                .append(localDate)
                .append(".json?")
                .append("app_id=")
                .append(codeId);

        ResponseEntity<CurrencyResponse> forEntity = restTemplate.getForEntity(urlString.toString(), CurrencyResponse.class);
        return forEntity.getBody();
    }
}
