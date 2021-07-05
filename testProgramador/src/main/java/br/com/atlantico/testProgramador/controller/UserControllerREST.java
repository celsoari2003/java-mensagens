package br.com.atlantico.testProgramador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atlantico.testProgramador.model.User;
import br.com.atlantico.testProgramador.service.IMessageService;
import br.com.atlantico.testProgramador.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserControllerREST {

	@Autowired
	private IUserService userService;

	@Autowired
	private IMessageService messageService;

	@GetMapping("/")
	@ApiOperation(value = "Consulta todos os usuários cadastrados no sistema")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso na operação de listar os usuários"),
			@ApiResponse(code = 400, message = "Erro ao consultar usuários"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<Iterable<User>>> getAllUsers() {
		return userService.getAllUsers().map(usuarios -> ResponseEntity.status(HttpStatus.OK).body(usuarios))
				.onErrorResume(Mono::error);
	}

	@PostMapping("/")
	@ApiOperation(value = "Inserir usuário na base de dados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário inserido com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao inserior usuário"),
			@ApiResponse(code = 401, message = "Você não está autorizado a inserir usuário na base")})
	public Mono<ResponseEntity<User>> createUser(@RequestBody User user) {
		return userService.insertUser(user).map(usuario -> ResponseEntity.status(HttpStatus.OK).body(usuario))
				.onErrorResume(Mono::error);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Consulta usuário por id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário encontrado com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao consultar usuário"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<User>> findUserById(@PathVariable Integer id) {
		return userService.getlUserById(id).map(usuario -> ResponseEntity.status(HttpStatus.OK).body(usuario))
				.onErrorResume(Mono::error);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta usuário da base de dados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário deletado com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao deletar usuário"),
			@ApiResponse(code = 401, message = "Você não está autorizado a deletar usuário"),
			@ApiResponse(code = 403, message = "Você esta proibido de deleter esse usuário"),
			@ApiResponse(code = 404, message = "O usuário que você esta tentando deletar não foi encontrado") })
	public Mono<ResponseEntity<User>> deleteUserById(@PathVariable Integer id) {
		return userService.deletelUserById(id).map(usuario -> ResponseEntity.status(HttpStatus.OK).body(usuario))
				.onErrorResume(Mono::error);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Consulta Contratos na BCP")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Contratos consultados com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao consultar contratos"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<User>> fullUpdateUser(@PathVariable Integer id) {
		return userService.fullUpdateUserById(id).map(usuarios -> ResponseEntity.status(HttpStatus.OK).body(usuarios))
				.onErrorResume(Mono::error);
	}

	@PatchMapping("/{id}")
	@ApiOperation(value = "Consulta Contratos na BCP")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Contratos consultados com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao consultar contratos"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<User>> updateUser(@PathVariable Integer id) {
		return userService.updateUserById(id).map(usuarios -> ResponseEntity.status(HttpStatus.OK).body(usuarios))
				.onErrorResume(Mono::error);
	}

	@PostMapping("/email/{id}")
	@ApiOperation(value = "Envia mensagem para um usuário especifico via REST API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Mensagem agendada para envio com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao agendar envio de mensagem"),
			@ApiResponse(code = 401, message = "Você não está autorizado a agender um envio de mensagem"),
			@ApiResponse(code = 403, message = "Você esta proibidio de agendar um envio de mensagem"),
			@ApiResponse(code = 404, message = "Não foi encontrado o usuário que você quer enviar uma mensagem") })
	public void emailToSingleUser(@PathVariable String id, @RequestBody String mensagem) {
		messageService.enviaMensagemAdmin(mensagem, id);
	}

	@PostMapping("/email")
	@ApiOperation(value = "Envia mensagem para todos os usuários via REST API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Mensagem agendada para envio com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao agendar envio de mensagem"),
			@ApiResponse(code = 401, message = "Você não está autorizado a agender um envio de mensagem"),
			@ApiResponse(code = 403, message = "Você esta proibidio de agendar um envio de mensagem") })
	public void emailToSingleUser(@RequestBody String mensagem) {
		messageService.enviaMensagemTodosAdmins(mensagem);
	}

}
