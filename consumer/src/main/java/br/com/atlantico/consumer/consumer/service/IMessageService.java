package br.com.atlantico.consumer.consumer.service;

import br.com.atlantico.consumer.consumer.model.Mensagem;
import reactor.core.publisher.Mono;

public interface IMessageService {

	public String enviaMensagemTodosAdmins(String mensagem);
	public String enviaMensagemAdmin(String mensagem, String Id);
	
	public Mono<Iterable<Mensagem>> getAllMensagem();
	
	
}
