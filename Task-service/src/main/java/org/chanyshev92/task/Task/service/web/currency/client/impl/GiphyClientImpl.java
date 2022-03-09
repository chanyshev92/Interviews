package org.chanyshev92.task.Task.service.web.currency.client.impl;

import lombok.RequiredArgsConstructor;
import org.chanyshev92.task.Task.service.web.currency.client.GiphyClient;
import org.chanyshev92.task.Task.service.web.currency.response.githyresp.GiphyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class GiphyClientImpl implements GiphyClient {

    @Value("${giphy.api.rich.method}")
    private String richUrl;

    @Value("${giphy.api.broke.method}")
    private String brokeUrl;

    private final RestTemplate restTemplate;
    
    @Override
    public byte[] getGif(boolean isRich) {
        String url;

        if(isRich) {url=richUrl;}
        else {url = brokeUrl;}

        ResponseEntity<GiphyResponse> forEntity = restTemplate.getForEntity(url, GiphyResponse.class);

        String urlGif = forEntity.getBody().getData().getEmbedUrl();
        System.out.println(urlGif);
       ResponseEntity<byte[]> forEntity1 = restTemplate.getForEntity(urlGif, byte[].class);

        return forEntity1.getBody();
    }
}
