package br.com.atlantico.testProgramador.service;

public interface IMessageService {

	public String enviaMensagemTodosAdmins(String mensagem);
	public String enviaMensagemAdmin(String mensagem, String Id);
	
}
