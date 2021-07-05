package br.com.atlantico.testProgramador;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.atlantico.testProgramador.model.Authority;
import br.com.atlantico.testProgramador.model.User;
import br.com.atlantico.testProgramador.repository.IAuthorityRepository;
import br.com.atlantico.testProgramador.service.IUserService;

@SpringBootApplication
public class TestProgramadorApplication {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAuthorityRepository authorityRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestProgramadorApplication.class, args);
	}	
	
	@PostConstruct
	private void  inserirAlgunsUsuariosParaTeste() {
		User celso = new User(1,"Celso","celso_ari2003","1234",null,null,"celso_ari2003@yahoo.com.br",true);
		Authority authority = new Authority(1, "celso_ari2003", "ROLE_USER");
		Authority authority2 = new Authority(2, "celso_ari2003", "ROLE_ADMIN");
		User celso2 = new User(2,"Celso2","celso_ari2","123456",null,null,"celso_ari@yahoo.com.br",false);
		userService.insertUser(celso);
		userService.insertUser(celso2);
		authorityRepository.save(authority);
		authorityRepository.save(authority2);
	}

}
