package br.com.atlantico.testProgramador.service;

import br.com.atlantico.testProgramador.model.User;
import reactor.core.publisher.Mono;

public interface IUserService {

	Mono<Iterable<User>> getAllUsers();

	Mono<User> getlUserById(Integer id);

	Mono<User> deletelUserById(Integer id);

	Mono<User> fullUpdateUserById(Integer id);

	Mono<User> updateUserById(Integer id);

	Mono<User> insertUser(User user);

}
