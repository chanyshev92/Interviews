package org.chanyshev92.task.Task.service.web.currency.controller;

import lombok.RequiredArgsConstructor;
import org.chanyshev92.task.Task.service.web.currency.client.GiphyClient;
import org.chanyshev92.task.Task.service.web.currency.client.impl.GiphyClientImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RequiredArgsConstructor
@RestController
public class GifController {

    private static String response;

    private final GiphyClient giphyClient;

    @GetMapping("/")
    public String getGif() throws IOException {
        response="";
        String gifUrl = giphyClient.getGifUrl(false);
        Files.lines(Path.of("gif.html")).forEach(item->response+=item);
        return response.replace("${placeforgif}",gifUrl);
    }
}
