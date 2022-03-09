package org.chanyshev92.task.Task.service.web.currency.controller;

import lombok.RequiredArgsConstructor;
import org.chanyshev92.task.Task.service.web.currency.client.impl.GiphyClientImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GifController {

    private final GiphyClientImpl giphyClient;

    @GetMapping("/")
    public byte[] getGif(){
        return giphyClient.getGif(false);
    }
}
