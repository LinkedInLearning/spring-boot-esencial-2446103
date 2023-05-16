package es.dsrroma.school.springboot.reuniones.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.dsrroma.school.springboot.reuniones.async.BuscaListener;

@Configuration
public class AsyncConfig {
	private static final String QUEUE_NAME = "busca-personas";
	private static final String EXCHANGE_NAME = "servicios";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange)
				.with("reuniones.busca.personas");
	}
	
	@Bean
	public MessageListenerAdapter listenerAdapter(BuscaListener listener) {
		return new MessageListenerAdapter(listener, "recibirMensaje");
	}
	
	@Bean
	public SimpleMessageListenerContainer container(
			ConnectionFactory connectionFactory, 
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = 
				new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE_NAME);
		container.setMessageListener(listenerAdapter);
		return container;
	}
}
