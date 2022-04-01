package org.chanyshev92.task.Task.service.web.githy.client.impl;

import org.chanyshev92.task.Task.service.web.currency.client.GiphyClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GiphyClientImplTest {

    @Autowired
    GiphyClient client;

    @Test
    void getGif() {
        client.getGifUrl(true);
    }
}