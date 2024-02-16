package com.melashvili.rabbitweb.config;

import com.melashvili.rabbitweb.consumer.RabbitMQConsumer;
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

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.routing.json.name}")
    private String queueJsonName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKeyName;

    @Value("${rabbitmq.routing.json.key}")
    private String routingKeyNameJson;

    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }

    public Queue jsonQueue(){
        return new Queue(routingKeyNameJson);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchangeName);
    }


    // binding between queue and exchange for routingKeyName
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKeyName);
    }

    // binding between queue and exchange for routingKeyNameJson
    @Bean
    public Binding bindingJson(){
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(routingKeyName);
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
