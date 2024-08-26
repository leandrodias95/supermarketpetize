package br.com.supermarketpetize.model.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.supermarketpetize.config.RabbitMQConfig;

@Service
public class OrderStatusMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrderStatusUpdateMessage(Long orderId, String newStatus) {
        OrderStatusUpdateMessage message = new OrderStatusUpdateMessage(orderId, newStatus);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
    }
}
