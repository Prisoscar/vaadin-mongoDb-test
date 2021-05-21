package com.example.application.data.document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.application.data.abstractDocument.AbstractUserDocument;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "user_document")
public class UserDocument extends AbstractUserDocument {
	
	@Size(min = 3, max = 20, message = "Name should contain between 3 and 20 characters")
	private String nome;
	@Min(value = 18, message = "age should be at least 18")
	@Max(value = 100, message = "age should be at most 100")
	private int eta;
	
	public UserDocument() {
		super();
	}

	public UserDocument(String username, String password, String nome, int eta) {
		super(username, password);
		this.nome = nome;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getEta() {
		return eta;
	}
	
	public void setEta(int eta) {
		this.eta = eta;
	}	
}
