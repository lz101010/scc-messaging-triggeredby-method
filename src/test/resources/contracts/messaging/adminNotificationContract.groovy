package contracts.messaging;

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label "notify admin"
    input {
        triggeredBy('notifyAdmin()')
    }

    outputMessage {
        sentTo("notifications")
        body([
                "message": "foobar"
        ])
        headers {
            header("amqp_receivedRoutingKey", "admin")
        }
    }
}