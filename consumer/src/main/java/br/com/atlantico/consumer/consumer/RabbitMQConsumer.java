package br.com.atlantico.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.atlantico.consumer.consumer.service.IMessageService;

@Component
public class RabbitMQConsumer {
	
	@Autowired
	private IMessageService messageService;

	@RabbitListener(queues = "user.queue")
	public void recievedMessage(String message){
		messageService.enviaMensagemTodosAdmins(message);
		System.out.println(message);
	}
	
}
