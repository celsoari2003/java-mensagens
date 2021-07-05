package br.com.atlantico.testProgramador.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.atlantico.testProgramador.model.Authority;

public interface IAuthorityRepository extends CrudRepository<Authority, Integer>{

}
