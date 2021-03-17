package com.example.messaging;

import com.example.ExampleApplication;

import org.springframework.amqp.rabbit.junit.RabbitAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;

@SpringBootTest(classes = ExampleApplication.class)
@AutoConfigureMessageVerifier
@RabbitAvailable
public abstract class NotificationBase {

    // need to mock the MessageReceiver bean in the application context
    // to effectively ignore messages sent by messageSender
    @MockBean
    protected MessageReceiver messageReceiver;

    @Autowired
    protected MessageSender messageSender;

    protected void notifyAdmin() {
        messageSender.notifyAdmin("foobar");
    }

    protected void notifyClients() {
        messageSender.notifyClients("fizzbuzz");
    }

}
