package com.example.application.data.document;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.application.data.abstractDocument.AbstractUser;

@Document(collection = "user_document")
public class UserDocument extends AbstractUser{
	
	private String nome;
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
