package com.midnightsun.exchangeratesconsumerservice.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WebSocketClientRunner implements ApplicationRunner {

    private final WebSocketClientHandler webSocketClientHandler;

    @Autowired
    public WebSocketClientRunner(WebSocketClientHandler webSocketClientHandler) {
        this.webSocketClientHandler = webSocketClientHandler;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Initializing websocket client");
        webSocketClientHandler.connectAndReceiveMessages();
    }
}
