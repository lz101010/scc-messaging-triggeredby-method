# Spring Cloud Contract: Messaging Tests triggered by Methods 

A minimal, reproducible example for configuring messaging tests with the following frameworks:
- [**Spring Boot 2.4**](https://spring.io/projects/spring-boot) - base platform
- [**Spring Cloud 2020.0.X**](https://spring.io/projects/spring-cloud) - augments Spring Boot to enable SCC and SCSt
- [**Spring Cloud Contract 3**](https://spring.io/projects/spring-cloud-contract) (SCC) - contract tests
- [**Spring Cloud Stream 3**](https://spring.io/projects/spring-cloud-stream) (SCSt) - provides binder for RabbitMQ

# Getting Started

## RabbitMQ
Spin up a local RabbitMQ instance with
```
$ docker run -d --name my-rabbit -p 5672:5672 rabbitmq:3-management
```
This pulls the official managment image from [Docker Hub](https://hub.docker.com/_/rabbitmq) and exposes port `5672`. RabbitMQ listens to this port and Spring AMQP will connect to `localhost:5672`. If you want to go to the UI on `localhost:15672` (credentials: `guest`/`guest`) make sure to expose this port as well:
```
$ docker run -d --name my-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```
You can stop and remove the container with
```
$ docker stop my-rabbit
$ docker rm my-rabbit
```

## Testing
Run `gradle test` or `gradle contractTest`.
