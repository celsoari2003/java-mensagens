package br.com.atlantico.testProgramador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.atlantico.testProgramador.model.User;
import br.com.atlantico.testProgramador.repository.IUserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public Mono<Iterable<User>> getAllUsers() {
		return Mono.just(userRepository.findAll());
	}

	@Override
	public Mono<User> getlUserById(Integer id) {
		//fazer o tratamento do optional
		return Mono.just(userRepository.findById(id).get());
	}

	@Override
	public Mono<User> deletelUserById(Integer id) {
		// ver para retornar alguma coisa
		User user = userRepository.findById(id).get();
		userRepository.deleteById(id);
		return Mono.just(user);
	}

	@Override
	public Mono<User> fullUpdateUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<User> updateUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<User> insertUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		
		user.setPassword(encoder.encode(user.getPassword()));	
		userRepository.save(user);	
		return Mono.just(user);
	}

}
