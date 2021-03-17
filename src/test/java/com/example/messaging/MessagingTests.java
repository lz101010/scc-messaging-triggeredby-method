package com.example.messaging;

import com.example.data.ExampleMessage;
import com.example.ExampleApplication;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.junit.RabbitAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = ExampleApplication.class)
@RabbitAvailable
final class MessagingTests {
    protected final static String DUMMY_MESSAGE = "foobar";
    protected final static ExampleMessage DUMMY_EXAMPLE_MESSAGE = new ExampleMessage(DUMMY_MESSAGE);

    @SpyBean
    protected MessageReceiver messageReceiver;

    @Autowired
    protected MessageSender messageSender;

    @Test
    void testAdminNotification() {
        messageSender.notifyAdmin(DUMMY_MESSAGE);

        verify(messageReceiver, timeout(1000)).receiveAdminNotification(DUMMY_EXAMPLE_MESSAGE);

        // verify other channels are empty
        verify(messageReceiver, never()).receiveClient1Notification(any(ExampleMessage.class));
        verify(messageReceiver, never()).receiveClient2Notification(any(ExampleMessage.class));
    }

    @Test
    void testClientsNotification() {
        messageSender.notifyClients(DUMMY_MESSAGE);

        verify(messageReceiver, timeout(1000)).receiveClient1Notification(DUMMY_EXAMPLE_MESSAGE);
        verify(messageReceiver, timeout(1000)).receiveClient2Notification(DUMMY_EXAMPLE_MESSAGE);

        // verify other channels are empty
        verify(messageReceiver, never()).receiveAdminNotification(any(ExampleMessage.class));
    }

}
