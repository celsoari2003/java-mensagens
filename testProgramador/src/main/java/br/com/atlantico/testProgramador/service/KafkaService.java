package br.com.atlantico.testProgramador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.atlantico.testProgramador.model.Mensagem;

@Service
public class KafkaService {

	@Autowired
	private KafkaTemplate<Object, Object> template;

	public void sendMessageUser(Mensagem mensagem) {
		this.template.send("mensagem", mensagem);
	}
	
}
