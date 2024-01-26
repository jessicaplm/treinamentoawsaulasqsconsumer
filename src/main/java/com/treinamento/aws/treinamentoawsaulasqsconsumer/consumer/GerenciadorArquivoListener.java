package com.treinamento.aws.treinamentoawsaulasqsconsumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.treinamento.aws.treinamentoawsaulasqsconsumer.consumer.model.request.ArquivoRequest;

@Component
public class GerenciadorArquivoListener {
	
	@Autowired
	private ObjectMapper object;
	
	@SqsListener(value = "${app.sqs.topic}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void arquivoListener(String mensagem, @Header("SenderId") String senderId) throws JsonMappingException, JsonProcessingException {
		System.out.println("Consumindo Sender ID: " + senderId);
		System.out.println("Consumindo mensagem: " + mensagem);
		
		ArquivoRequest request = object.readValue(mensagem, ArquivoRequest.class);
		
		System.out.println("Objeto Mapeado: " + request.getNomeArquivo());
	}
}
