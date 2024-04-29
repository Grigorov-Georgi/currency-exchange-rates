package com.midnightsun.exchangeratesconsumerservice.websocket;

import com.midnightsun.exchangeratesconsumerservice.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;

import java.net.URI;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class WebSocketClientHandler {

    @Value("${websocket.url}")
    private String websocketUrl;
    private final ExchangeRateService exchangeRateService;

    public WebSocketClientHandler(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public void connectAndReceiveMessages() {
        ReactorNettyWebSocketClient client = new ReactorNettyWebSocketClient();

        try {
            URI url = new URI(websocketUrl);
            CountDownLatch latch = new CountDownLatch(1);

            client.execute(url, session ->
                    session.receive()
                            .doOnNext(message -> exchangeRateService.save(message.getPayloadAsText()))
                            .then()
                            .doFinally(signalType -> latch.countDown())
            ).subscribe();

            latch.await();
        } catch (Exception e) {
            log.error("Error consuming exchange rates from WebSocket");
        }
    }
}

