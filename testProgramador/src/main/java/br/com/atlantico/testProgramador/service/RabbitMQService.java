package br.com.atlantico.testProgramador.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${atlantico.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${atlantico.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(String mensagem) {
		rabbitTemplate.convertAndSend(exchange, routingkey, mensagem);
		System.out.println("Send msg = " + mensagem);	    
	}
	
}
