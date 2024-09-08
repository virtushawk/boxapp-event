package com.virtushawk.boxappevent.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Simple configuration for rabbitMQ
 */
@Configuration
public class RabbitMQConfig {

    /**
     * Queue name for unregister user event
     */
    public static final String UNREGISTER_QUEUE_NAME = "boxapp.queue.event.unregister";

    /**
     * Simple exchange name
     */
    public static final String EXCHANGE_NAME = "boxapp.exchange";

    /**
     * Simple not durable queue bean for {@link RabbitMQConfig#UNREGISTER_QUEUE_NAME}
     */
    @Bean
    public Queue queue() {
        return new Queue(UNREGISTER_QUEUE_NAME, false);
    }

    /**
     * Simple exchange bean
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * Binding bean for {@link RabbitMQConfig#UNREGISTER_QUEUE_NAME}
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("event.unregister");
    }
}
