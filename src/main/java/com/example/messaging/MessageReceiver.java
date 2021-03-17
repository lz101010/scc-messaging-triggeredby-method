package com.example.messaging;

import com.example.data.ExampleMessage;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageReceiver {

    @StreamListener(MessageChannels.ADMIN_IN)
    public void receiveAdminNotification(ExampleMessage message) {
        log.info("Received admin notification: {}", message);
    }

    @StreamListener(MessageChannels.CLIENTS_IN)
    public void receiveClient1Notification(ExampleMessage message) {
        log.info("Received notification for client 1: {}", message);
    }

    @StreamListener(MessageChannels.CLIENTS_IN)
    public void receiveClient2Notification(ExampleMessage message) {
        log.info("Received notification for client: {}", message);
    }

}
