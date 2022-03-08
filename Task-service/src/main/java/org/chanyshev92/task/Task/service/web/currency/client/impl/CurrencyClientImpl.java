package org.chanyshev92.task.Task.service.web.currency.client.impl;

import lombok.RequiredArgsConstructor;
import org.chanyshev92.task.Task.service.web.currency.client.CurrencyClient;
import org.chanyshev92.task.Task.service.web.currency.response.Rates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CurrencyClientImpl implements CurrencyClient {

    private final RestTemplate restTemplate;

    private String url;

    @Value("${currency.code.id}")
    private String codeId;

    @Value("${currency.url}") String urlValue;
    @Value("${currency.get-rates.method}") String methodValue;


    @Override
    public Rates getRatesByDate(LocalDate localDate) {
        StringBuilder urlString = new StringBuilder();
        urlString
                .append(urlValue)
                .append(methodValue)
                .append("/")
                .append(localDate)
                .append(".json?")
                .append("app_id=")
                .append(codeId);

        ResponseEntity<Rates> forEntity = restTemplate.getForEntity(urlString.toString(), Rates.class);
        return forEntity.getBody();
    }
}
