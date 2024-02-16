package com.melashvili.rabbitbq.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello", false);
    }
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public CommandLineRunner send(){
        return args -> {
            String message = "Hello RabbitMQ";
            rabbitTemplate.convertAndSend("hello", message);
            System.out.println(message);
        };
    }
}
