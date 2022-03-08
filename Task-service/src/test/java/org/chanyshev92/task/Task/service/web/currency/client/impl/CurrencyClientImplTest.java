package org.chanyshev92.task.Task.service.web.currency.client.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class CurrencyClientImplTest {

    @Autowired
    private CurrencyClientImpl client;
    @Test
    public void getCurrencyTest(){
        client.getRatesByDate(LocalDate.now());

    }

}