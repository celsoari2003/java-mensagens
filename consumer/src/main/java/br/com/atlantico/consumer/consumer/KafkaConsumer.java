package br.com.atlantico.consumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.atlantico.consumer.consumer.model.Mensagem;
import br.com.atlantico.consumer.consumer.service.IMessageService;

@Component
@KafkaListener(id = "multiGroup", topics = { "message"})
public class KafkaConsumer {

	@Autowired
	private IMessageService messageService;
	
	@KafkaHandler
	public void foo(Mensagem mensagem) {
		messageService.enviaMensagemAdmin(mensagem.getMensagem(), mensagem.getUserId());
	}
	
}
