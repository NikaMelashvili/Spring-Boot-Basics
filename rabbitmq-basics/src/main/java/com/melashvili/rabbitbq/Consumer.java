package com.melashvili.rabbitbq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "hello")
    public void received(String message){
        System.out.println(message);
    }
}
