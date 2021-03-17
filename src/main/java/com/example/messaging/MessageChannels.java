package com.example.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageChannels {

    // no idea why the 'v2-' prefix is needed for the channel to be created
    // when running the contract tests
    public static final String ADMIN_IN = "v2-admin-in";
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
