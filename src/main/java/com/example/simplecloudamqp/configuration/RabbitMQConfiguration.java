package com.example.simplecloudamqp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;

@Configuration
public class RabbitMQConfiguration {

    public static final String QUEUE_NAME = "simpleQueue";
    public static final String EXCHANGE_NAME = "simpleExchange";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){
        return  BindingBuilder.bind(queue).to(exchange).with("routingKey");
    }
}
