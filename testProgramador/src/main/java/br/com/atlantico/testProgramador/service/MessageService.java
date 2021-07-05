package br.com.atlantico.testProgramador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService{

	@Autowired
	private RabbitMQService rabbitMQService;
	
	@Override
	public String enviaMensagemTodosAdmins(String mensagem) {
		rabbitMQService.send(mensagem);
		return "resultado para todos";		
	}

	@Override
	public String enviaMensagemAdmin(String mensagem, String id) {
		rabbitMQService.send(mensagem);
		return "resultado para um usuario com o Id:"+id;
	}

}
