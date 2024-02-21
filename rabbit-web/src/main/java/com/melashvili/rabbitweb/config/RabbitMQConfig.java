package com.melashvili.rabbitweb.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    // spring will automatically create there beans:
    // ConnectionFactory
    // RabbitTemplate
    // RabbitAdmin

    // a name of the primary queue
    @Value("${rabbitmq.queue.name}")
    private String queue;

    // an exchange name for primary queue
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    // routing key for the primary queue and exchange
    @Value("${rabbitmq.routing.key}")
    private String routingKeyName;

    @Value("${rabbitmq.queue.json}")
    private String queueJson;

    @Value("${rabbitmq.routing.json}")
    private String routingKeyJson;


    //creates a new queue bean
    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    // creates a new exchange bean
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    // binding between queue and exchange for routingKeyName
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKeyName);
    }

    // queue for json messages
    @Bean
    public Queue jsonQueue(){
        return new Queue(queueJson);
    }

    // binding between queue and exchange for routingKeyNameJson
    @Bean
    public Binding bindingJson(){
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(routingKeyJson);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
