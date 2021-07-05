package br.com.atlantico.testProgramador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.atlantico.testProgramador.service.IMessageService;
import https.www_atlantico_com_br.celso._super.developer.MensagemParaTodosRequest;
import https.www_atlantico_com_br.celso._super.developer.MensagemParaTodosResponse;
import https.www_atlantico_com_br.celso._super.developer.MensagemParaUsuarioRequest;
import https.www_atlantico_com_br.celso._super.developer.MensagemParaUsuarioResponse;

@Endpoint
public class MensagenControllerSOAP {

    private IMessageService messageService;

    @Autowired
    public MensagenControllerSOAP(IMessageService messageService) {
        this.messageService = messageService;
    }

    @PayloadRoot(namespace="https://www.atlantico.com.br/celso/super/developer" , localPart="mensagemParaTodosRequest")
    @ResponsePayload
    public MensagemParaTodosResponse getCountry(@RequestPayload MensagemParaTodosRequest request) {
    	MensagemParaTodosResponse response = new MensagemParaTodosResponse();
        response.setStatus(messageService.enviaMensagemTodosAdmins(request.getMensagem()));
        return response;
    }
    
    @PayloadRoot(namespace = "https://www.atlantico.com.br/celso/super/developer", localPart = "mensagemParaUsuarioRequest")
    @ResponsePayload
    public MensagemParaUsuarioResponse getCountry(@RequestPayload MensagemParaUsuarioRequest request) {
    	MensagemParaUsuarioResponse response = new MensagemParaUsuarioResponse();
        response.setOperationStatus(messageService.enviaMensagemAdmin(request.getMensagem(), request.getUsuario()));
        return response;
    }
}
