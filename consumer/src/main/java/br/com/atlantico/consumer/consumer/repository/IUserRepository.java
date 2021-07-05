package br.com.atlantico.consumer.consumer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.atlantico.consumer.consumer.model.User;


public interface IUserRepository extends CrudRepository<User, Integer>{

	List<User> findByAdmin(Boolean admin);
}
