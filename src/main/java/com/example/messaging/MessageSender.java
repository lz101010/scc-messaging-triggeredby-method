package com.example.messaging;

import com.example.data.ExampleMessage;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageSender {
    private final MessageChannels channels;

    public void notifyAdmin(String message) {
        channels.adminNotificationsOut().send(makeMessage(message));
    }

    public void notifyClients(String message) {
        channels.clientsNotificationsOut().send(makeMessage(message));
    }

    private static Message makeMessage(String message) {
        return MessageBuilder.withPayload(new ExampleMessage(message)).build();
    }
}
