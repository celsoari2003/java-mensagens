package br.com.atlantico.testProgramador.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.atlantico.testProgramador.model.User;


public interface IUserRepository extends CrudRepository<User, Integer>{

}
