package com.example.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageChannels {

    public static final String ADMIN_IN = "admin-in";
    public static final String ADMIN_OUT = "admin-out";

    public static final String CLIENTS_IN = "clients-in";
    public static final String CLIENTS_OUT = "clients-out";

    @Input(ADMIN_IN)
    MessageChannel adminNotificationsIn();

    @Output(ADMIN_OUT)
    MessageChannel adminNotificationsOut();

    @Input(CLIENTS_IN)
    MessageChannel clientsNotificationsIn();

    @Output(CLIENTS_OUT)
    MessageChannel clientsNotificationsOut();

}
