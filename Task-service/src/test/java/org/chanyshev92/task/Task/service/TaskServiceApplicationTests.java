package org.chanyshev92.task.Task.service;


import org.chanyshev92.task.Task.service.web.currency.client.impl.CurrencyClientImpl;
import org.chanyshev92.task.Task.service.web.currency.response.Rates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

@SpringBootTest
class TaskServiceApplicationTests {

	@Autowired
	private CurrencyClientImpl client;

	@Test
	void contextLoads() {

		Rates rates = client.getRatesByDate(LocalDate.now());
		Assertions.assertNotNull(rates);
	}

}
