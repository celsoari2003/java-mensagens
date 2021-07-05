package br.com.atlantico.consumer.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atlantico.consumer.consumer.model.Mensagem;
import br.com.atlantico.consumer.consumer.model.User;
import br.com.atlantico.consumer.consumer.repository.IMessageRepository;
import br.com.atlantico.consumer.consumer.repository.IUserRepository;
import reactor.core.publisher.Mono;

@Service
public class MessageService implements IMessageService{

	@Autowired
	private IMessageRepository messageRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public String enviaMensagemTodosAdmins(String mensagem) {
		
		List<User> admins = userRepository.findByAdmin(true);
		
		for(User admin: admins) {
			Mensagem currentMensagem = new Mensagem();
			currentMensagem.setMensagem(mensagem);
			currentMensagem.setUserId(admin.getId().toString());
			messageRepository.save(currentMensagem);
		}
		
		return mensagem;		
	}

	@Override
	public String enviaMensagemAdmin(String mensagem, String id) {
		Mensagem currentMensagem = new Mensagem();
		currentMensagem.setMensagem(mensagem);
		currentMensagem.setUserId(id);
		messageRepository.save(currentMensagem);
		return mensagem;
	}

	@Override
	public Mono<Iterable<Mensagem>> getAllMensagem() {
		return Mono.just(messageRepository.findAll());
	}

}
