package br.com.atlantico.consumer.consumer.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.atlantico.consumer.consumer.model.Mensagem;

public interface IMessageRepository extends CrudRepository<Mensagem, Integer>{

}
