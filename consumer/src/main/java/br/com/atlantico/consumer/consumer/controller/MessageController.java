package br.com.atlantico.consumer.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atlantico.consumer.consumer.model.Mensagem;
import br.com.atlantico.consumer.consumer.service.IMessageService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*")
public class MessageController {
	
	@Autowired
	private IMessageService messageService;

	@GetMapping("/")	
	public Mono<ResponseEntity<Iterable<Mensagem>>> getAllUsers() {
		return messageService.getAllMensagem()
				.map(mensagens -> ResponseEntity.status(HttpStatus.OK).body(mensagens))
				.onErrorResume(Mono::error);
	}
	
}
