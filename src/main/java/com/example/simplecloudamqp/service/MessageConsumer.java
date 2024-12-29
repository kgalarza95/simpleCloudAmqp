package com.example.simplecloudamqp.service;

import com.example.simplecloudamqp.configuration.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfiguration.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);
    }
}
