package com.melashvili.rabbitweb.consumer;

import com.melashvili.rabbitweb.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.routing.json}"})
    public void consumeJsonMessage(User user){
        LOGGER.info(String.format("Received Json message -> %s", user.toString()));
    }
}
