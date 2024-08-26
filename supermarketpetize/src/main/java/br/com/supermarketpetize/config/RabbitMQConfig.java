package br.com.supermarketpetize.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

	
	public static final String EXCHANGE_NAME = "order_status_exchange"; 
	public static final String QUEUE_NAME = "order_status_queue"; 
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}
	
	@Bean
	 public Binding binding(Queue queue, TopicExchange exchange) {
	        return BindingBuilder.bind(queue).to(exchange).with("order.status.updated");
	    }
}
