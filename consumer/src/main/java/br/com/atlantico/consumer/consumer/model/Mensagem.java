package br.com.atlantico.consumer.consumer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "mensagem")
public class Mensagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String mensagem;
	private String userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Mensagem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mensagem(Integer id, String mensagem, String userId) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.userId = userId;
	}
	
	
	
}
