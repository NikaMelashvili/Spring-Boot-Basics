package com.melashvili.rabbitweb.controller;

import com.melashvili.rabbitweb.dto.User;
import com.melashvili.rabbitweb.publisher.RabbitMQJsonProducer;
import com.melashvili.rabbitweb.publisher.RabbitMQProducer;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageJsonController {

    private RabbitMQJsonProducer rabbitMQProducer;

    public MessageJsonController(RabbitMQJsonProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to rabbitmq");
    }
}
